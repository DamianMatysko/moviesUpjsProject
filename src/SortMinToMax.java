import java.util.Comparator;

public class SortMinToMax implements Comparator<Films>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Films a, Films b)
    {
        return a.time - b.time;
    }
}
