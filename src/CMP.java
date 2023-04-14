import java.util.Comparator;

public class CMP implements Comparator<OBJECTS> {

    @Override
    public int compare(OBJECTS o1, OBJECTS o2) {
        if (o1.frq > o2.frq)
            return -1;
        else if (o1.frq == o2.frq)
            return 0;
        else
            return 1;
    }
}
