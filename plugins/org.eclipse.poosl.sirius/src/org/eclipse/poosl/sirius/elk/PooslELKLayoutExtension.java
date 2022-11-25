package org.eclipse.poosl.sirius.elk;

import java.util.Iterator;

import org.eclipse.elk.core.service.LayoutMapping;
import org.eclipse.elk.graph.ElkConnectableShape;
import org.eclipse.elk.graph.ElkEdge;
import org.eclipse.elk.graph.ElkEdgeSection;
import org.eclipse.elk.graph.ElkLabel;
import org.eclipse.elk.graph.ElkPort;
import org.eclipse.elk.graph.util.ElkGraphUtil;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.elk.GmfLayoutCommand;
import org.eclipse.sirius.diagram.elk.IELKLayoutExtension;

public class PooslELKLayoutExtension implements IELKLayoutExtension {

    private static final String[] SOURCE_PORT_PATTERNS = new String[] { "out", "computation" };

    private static final String[] TARGET_PORT_PATTERNS = new String[] { "in", "control" };

    @Override
    public void beforeELKLayout(LayoutMapping layoutMapping) {
        Iterator<EObject> iterator = layoutMapping.getLayoutGraph().eAllContents();
        while (iterator.hasNext()) {
            EObject eObject = iterator.next();
            if (eObject instanceof ElkEdge && isEdgeInWrongDirection((ElkEdge) eObject)) {
                reverseEdge((ElkEdge) eObject);
            }
        }
    }

    @Override
    public void afterELKLayout(LayoutMapping layoutMapping) {
    }

    @Override
    public void afterGMFCommandApplied(
            GmfLayoutCommand gmfLayoutCommand, LayoutMapping layoutMapping) {
    }

    private void reverseEdge(ElkEdge elkEdge) throws IllegalArgumentException {
        ElkConnectableShape source = elkEdge.getSources().get(0);
        ElkConnectableShape target = elkEdge.getTargets().get(0);

        elkEdge.getSources().remove(source);
        elkEdge.getSources().add(target);

        elkEdge.getTargets().remove(target);
        elkEdge.getTargets().add(source);

        for (ElkEdgeSection section : elkEdge.getSections()) {
            double oldStartX = section.getStartX();
            double oldStartY = section.getStartY();
            section.setStartX(section.getEndX());
            section.setStartY(section.getEndY());
            section.setEndX(oldStartX);
            section.setEndY(oldStartY);

            ECollections.reverse(section.getBendPoints());
        }
    }

    private boolean isEdgeInWrongDirection(ElkEdge edge) {
        ElkPort sourcePort = ElkGraphUtil.getSourcePort(edge);
        boolean invalidSource = sourcePort != null && getPortKind(sourcePort) == PortKind.TARGET;

        ElkPort targetPort = ElkGraphUtil.getTargetPort(edge);
        boolean invalidTarget = targetPort != null && getPortKind(targetPort) == PortKind.SOURCE;

        return !edge.isHyperedge() && (invalidSource || invalidTarget);
    }

    enum PortKind {
        SOURCE, TARGET, UNDEFINED
    }

    private PortKind getPortKind(ElkPort port) {
        for (ElkLabel label : port.getLabels()) {
            for (String sourcePattern : SOURCE_PORT_PATTERNS) {
                if (label.getText().toLowerCase().contains(sourcePattern)) {
                    return PortKind.SOURCE;
                }
            }
            for (String sourcePattern : TARGET_PORT_PATTERNS) {
                if (label.getText().toLowerCase().contains(sourcePattern)) {
                    return PortKind.TARGET;
                }
            }
        }
        return PortKind.UNDEFINED;
    }

}
