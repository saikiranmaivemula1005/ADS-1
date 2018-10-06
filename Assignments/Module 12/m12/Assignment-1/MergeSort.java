import java.util.Comparator;
class MergeSort<T> {
    private  T[] aux;
    public  void sort(T[] a, Comparator<T> cp) {
        aux = (T[]) new Object[a.length];
        sort(a, 0, a.length - 1, cp);
    }
    private void merge(T[] a, int lo, int mid, int hi, Comparator<T> cp) {
        int i = lo, j = mid + 1;
        
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi )              a[k] = aux[i++];
            else if (less(aux[j], aux[i], cp)) a[k] = aux[j++];
            else                           a[k] = aux[i++];
    }
    private boolean less(T a, T b, Comparator<T> cp) {
        return cp.compare(a,b) < 0;
    }
    private void sort(T[] a, int lo, int hi, Comparator<T> cp) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid, cp);
        sort(a, mid + 1, hi, cp);
        merge(a, lo, mid, hi, cp);
    }
}
