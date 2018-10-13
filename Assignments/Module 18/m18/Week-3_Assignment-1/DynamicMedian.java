/**
 * Class for dynamic median.
 */
class DynamicMedian {
    /**
     *the object to access of minheap.
     */
    private MinPQ<Float> minObj;
    /**
     *the object to access of maxheap.
     */
    private MaxPQ<Float> maxObj;
    /**
     *the constructor for initializing.
     */
    DynamicMedian() {
        minObj = new MinPQ<Float>();
        maxObj = new MaxPQ<Float>();
    }
    /**
     *the method will insert the element
     *to minheap.
     * @param      item  The item
     */
    public void insertAtMin(final float item) {
        minObj.insert(item);
    }
    public void printmin() {
        minObj.print();
    }
    public void printmax() {
        maxObj.print();
    }
    /**
     *the method will insert the element
     *to maxheap.
     * @param      item  The item
     */
    public void insertAtMax(final float item) {
        maxObj.insert(item);
    }
    /**
     *this method gets the minimum element.
     * from minheap.
     * @return     The minimum.
     */
    public float getMin() {
        return minObj.min();
    }
    /**
     *this method gets the maximum element.
     * from maxheap.
     * @return     The minimum.
     */
    public float getMax() {
        return maxObj.max();
    }
    /**
     *this method delete the maximum element.
     * from maxheap.
     * @return     The minimum.
     */
    public float delMax() {
        return maxObj.delMax();
    }
    /**
     *this method delete the minimum element.
     * from maxheap.
     * @return     The minimum.
     */
    public float delMin() {
        return minObj.delMin();
    }
    /**
     *gets the size of minheap.
     *
     * @return     The minimum size.
     */
    public int getMinSize() {
        return minObj.size();
    }
    /**
     * Gets the maximum size of maxheap.
     *
     * @return     The maximum size.
     */
    public int getMaxSize() {
        return maxObj.size();
    }
}