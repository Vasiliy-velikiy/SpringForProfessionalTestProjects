
public class ReplacementTarget {

    public String formatMessage(String msg) {
        return "<hl>" + msg + "</hl>";
    }

    public String formatMessage(Object msg) {
        return "<hl>" + msg + "</hl>";
    }
}