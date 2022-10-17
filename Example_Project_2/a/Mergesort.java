package a;

public class Mergesort {
	public static void mergeSort(PriorityQueueItem queue[], int n, int m) {
		int mid = (n+m) / 2;
		
		if((m-n) <= 0) {
			return;
		}
		else if((m-n) > 1) {
			mergeSort(queue, n, mid);
			mergeSort(queue, mid+1, m);
		}
		merge(queue, n, m);
	}
	
	public static void merge(PriorityQueueItem queue[], int n, int m) {
		if((m-n) <= 0) {
			return;
		}
		int mid = (n+m) / 2;
		int a, b, k;
		int n1 = mid - n + 1;
	    int n2 = m - mid;
		PriorityQueueItem L[] = new PriorityQueueItem[n1];
		PriorityQueueItem R[] = new PriorityQueueItem[n2];
		
		for(int i=0;i<n1;i++) {
	        L[i] = queue[n+i];
	    }
	    for(int j=0;j<n2;j++) {
	        R[j] = queue[mid+1+j];
	    }

	    // merge the 2 temp arrays back into list[n...m]
	    a = 0;
	    b = 0;
	    k = n;

	    while(a<n1 && b<n2) {
	        if(L[a].getWeight() >= R[b].getWeight()) {
	            queue[k] = L[a];
	            a++;
	        }
	        else {
	            queue[k] = R[b];
	            b++;
	        }
	        k++;
	    }

	    // copy remaining elements of L[] and R[] if any to list[]
	    while(a<n1) {
	        queue[k] = L[a];
	        a++;
	        k++;
	    }

	    while(b<n2) {
	        queue[k] = R[b];
	        b++;
	        k++;
	    }
		
	}

}
