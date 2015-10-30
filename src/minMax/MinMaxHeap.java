package minMax;



public class MinMaxHeap {
	 // DO NOT CHANGE THESE VARIABLES AND METHODS
    private int currentSize;
    private int[] arr;
    public MinMaxHeap(int capacity){//Constructor
        arr = new int[capacity + 1];
        currentSize = 0;
}
    public boolean isFull(){return currentSize == arr.length - 1;}
    public boolean isEmpty(){return currentSize == 0;}
    // COMPLETE THE FOLLOWING METHODS
    public void insert(int x){//PRE: The heap is not full
    	currentSize++;
    	arr[currentSize] = x;
    	bubbleUp(currentSize);
    }
    public int min(){return arr[1];}//PRE: The heap is not empty
    public int max(){//PRE: The heap is not empty
    	if (1 == currentSize) {
    		return arr[1];
    	}
    	if (2 <= currentSize) {
    		if (currentSize != 2 && arr[3] > arr[2]) {
    		return arr[3];
    		}
    		return arr[2];
    	}
    	return 0;
    }
    public int deleteMin(){//PRE: The heap is not empty
    	int minItem = min();
    	arr[1] = arr[currentSize--];
    	trickleDown(1);
    	return minItem;
    }
    public int deleteMax(){//PRE: The heap is not empty
    	int n = 0;
    	int max = max();
    	for (int i=1; i<=3; i++) {
    		if (arr[i] == arr[n]){
    			n = i;
    			break;
    		}
    	}
    	arr[n] = arr[currentSize--];
    	trickleDown(n);
    	return max;
    }
    
    // Private methods go here.
    
    private boolean minLevel(int i) {
    	if (Math.floor(Math.log(i)/Math.log(2)) % 2 == 0) {
    		return true;
    	}
    	return false;
    }
    
	private void swap(int l, int u) {
		int temp = arr[l];
		arr[l] = arr[u];
		arr[u] = temp;
	}
	
    private void trickleDown(int i) {
    	if (minLevel(i) == true) {
    		trickleDownMin(i);
    	} else trickleDownMax(i);
    }
    	
    	
    private void trickleDownMin(int i) {	
    	int child, grandchild, min;
    	
    	if (i * 2 <= currentSize) {
    		child = i * 2;
    		if (child != currentSize && arr[child+1] < arr[child]) {
    			child++;
    		}
    		if (i * 4 <= currentSize) {
    			grandchild = i * 4;
    			min = grandchild;
    			if (grandchild + 1 <= currentSize && arr[grandchild+1] < arr[min]) {
    				min = grandchild + 1;
    			}
    			if (grandchild + 2 <= currentSize && arr[grandchild+2] < arr[min]) {
    				min = grandchild + 2;
    			}
    			if (grandchild + 3 <= currentSize && arr[grandchild+3] < arr[min]) {
    				min = grandchild + 3;
    			}
    			if (arr[min] < arr[child]) {
    				if (arr[min] < arr[i]) {
    					swap(i, min);
    					if (arr[min] > arr[min/2]) {
    						swap(min, min/2);
    					}
    					trickleDownMin(min);
    				}
    			}
    		}
    		if (arr[child] < arr[i]) {
    			swap(i, child);
    			}
    		}
    	}

    private void trickleDownMax(int i) {	
    	int child, grandchild, min;
    	
    	if (i * 2 <= currentSize) {
    		child = i * 2;
    		if (child != currentSize && arr[child+1] > arr[child]) {
    			child++;
    		}
    		if (i * 4 <= currentSize) {
    			grandchild = i * 4;
    			min = grandchild;
    			if (grandchild + 1 <= currentSize && arr[grandchild+1] > arr[min]) {
    				min = grandchild + 1;
    			}
    			if (grandchild + 2 <= currentSize && arr[grandchild+2] > arr[min]) {
    				min = grandchild + 2;
    			}
    			if (grandchild + 3 <= currentSize && arr[grandchild+3] > arr[min]) {
    				min = grandchild + 3;
    			}
    			if (arr[min] > arr[child]) {
    				if (arr[min] > arr[i]) {
    					swap(i, min);
    					if (arr[min] < arr[min/2]) {
    						swap(min, min/2);
    					}
    					trickleDownMax(min);
    				}
    			}
    		}
    		if (arr[child] > arr[i]) {
    			swap(i, child);
    			}
    		}
    	}
    
    private void bubbleUp(int i) {
    	if (minLevel(i) == true) {
      		if (i != 1 && arr[i] > arr[i/2]) {
      			swap(i, i/2);
      			bubbleUpMax(i/2);
      		} else {
      			bubbleUpMin(i);
      		}
      	} else {
      		if (i != 1 && arr[i] < arr[i/2]) {
      			swap(i, i/2);
      			bubbleUpMin(i/2);
      		} else {
      			bubbleUpMax(i);
      		}
      	}
    }
    
    private void bubbleUpMin(int i) {
    	if (i >= 4) {
    		if (arr[i] < arr[i/4]) {
    			swap(i, i/4);
    			bubbleUpMin(i/4);
    		}
    	} else {
    		if (arr[i] < arr[1]) {
    			swap(i, 1);
    		}
    	}
    }
    
    private void bubbleUpMax(int i) {
    	if (i >= 4) {
    		if (arr[i] > arr[i/4]) {
    			swap(i, i/4);
    			bubbleUpMax(i/4);
    		}
    	}
    }
}
