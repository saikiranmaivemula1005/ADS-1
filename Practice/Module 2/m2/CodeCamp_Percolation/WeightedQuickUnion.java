class WeightedQuickUnion {
	private int[] id;
	private int[] size;
	private int count;
	WeightedQuickUnion(int n) {
		count = n;
		id = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
		for (int i = 0; i < n; i++) {
			size[i] = 1;
		}
	}
	public int count() {
		return count;
	}
	public boolean connected(int a, int b) {
		return find(a) == find(b);
	}
	public int find(int a) {
		while (a != id[a]) {
			a = id[a];
			//return a;
		}
		return a;
	}
	public void Union(int a, int b) {
		if (find(a) == find(b)) {
			return;
		}
		if (size[find(a)] < size[find(b)]) {
			id[find(a)] = find(b);;
			size[find(b)] += size[find(a)];
		} else {
			id[find(b)] = find(a);;
			size[find(a)] += size[find(b)];
		}
		count--;
	}
}
