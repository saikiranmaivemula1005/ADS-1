import java.util.Arrays;
class MergeSort {
	int[] auxillaryArray;
	int[] array;
	public void sort(int[] array) {
		this.array = array;
		auxillaryArray = new int[array.length];
		sort(array, 0, array.length - 1);
	}
	public void sort(int[] array, int low, int high) {
		if (high <= low) {
			return;
		}
		int mid = low + (high - low) / 2;
		sort(array, low, mid);
		sort(array, mid + 1, high);
		merge(array, low, mid, high);
	}
	public void merge(int[] array, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;

		for (int m = low; m <= high; m++) {
			auxillaryArray[m] = array[m];
		}
		for (int k = low; k <= high; k++) {
			if (i > mid) {
				array[k] = auxillaryArray[j++];
			} else if (j > high) {
				array[k] = auxillaryArray[i++];
			} else if(lessthan(auxillaryArray[j], auxillaryArray[i])) {
				array[k] = auxillaryArray[j++];
			} else {
				array[k]= auxillaryArray[i++];
			}
		}
	}
	public boolean lessthan(int i, int j) {
		return j > i;
	}
	public String toString() {
		System.out.println(Arrays.toString(array));
		return "";
	}
}