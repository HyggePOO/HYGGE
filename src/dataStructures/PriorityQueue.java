package dataStructures;

import data.NegocioBusqueda;

public class PriorityQueue {

	private int n;
	private NegocioBusqueda array[];
	private int size;
	
	public PriorityQueue(int n) {
		array=new NegocioBusqueda[n];
		size = 0;
	}
	

	public void insertItem(NegocioBusqueda x) {
//		if(size==n) {
//			return;
//		}
		array[size] = x;
		moveUp();
		size++;
	}

	private void moveUp() {
		int child = size;
		int parent = (child-1)/2;
		NegocioBusqueda temp = array[child];

	
		while(child > 0 && temp.getCalificacion() > array[parent].getCalificacion()) {
			array[child] = array[parent];
			child = parent;
			parent = (child-1)/2;
		}
		array[child]=temp;
	}


	public NegocioBusqueda removeMax() {

		NegocioBusqueda max=array[0];
		array[0]=array[--size];
		moveDown();
		return max;

	}


	private void moveDown() {

	boolean flag = false;
	NegocioBusqueda biggest = null;
	int parent = 0;
	int child = 2*parent+1;
	NegocioBusqueda temp = array[parent];
	while(child < size && !flag) {
		biggest = array[child];
		if(child+1 < size && array[child+1].getCalificacion() > array[child].getCalificacion())
			biggest = array[++child];
		if(biggest.getCalificacion() > temp.getCalificacion()) {
			array[parent] = biggest;
			parent = child;
			}else
				flag = true;
		child = 2*parent+1;
		}
	array[parent] = temp;

	}
}
