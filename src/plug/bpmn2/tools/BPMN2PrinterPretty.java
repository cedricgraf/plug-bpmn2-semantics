package plug.bpmn2.tools;

import org.eclipse.bpmn2.DocumentRoot;
import org.eclipse.bpmn2.util.Bpmn2Switch;
import org.eclipse.emf.ecore.EObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:luka.le_roux@ensta-bretagne.fr">Luka Le Roux</a>
 */
public class BPMN2PrinterPretty extends Bpmn2Switch<List<String>> {

    static final private String INDENT = "    ";

    static final private void indentAll(List<String> stringList) {
        stringList.replaceAll(s -> INDENT + s);
    }

    private final BPMN2PrinterShort shortPrinter;
    int level;
    List<String> result;
    Set<EObject> known;

    public BPMN2PrinterPretty() {
        shortPrinter = new BPMN2PrinterShort();
    }

    public List<String> getPrettyPrint(EObject object) {
        level = 0;
        result = new ArrayList<String>();
        known = new HashSet<>();
        return doSwitch(object);
    }

    @Override
    public List<String> caseDocumentRoot(DocumentRoot object) {
        return super.caseDocumentRoot(object);
    }
}
