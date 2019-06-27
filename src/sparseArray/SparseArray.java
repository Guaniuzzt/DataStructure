package sparseArray;

public class SparseArray {

	public static void main(String[] args) {
		
		int[][] array = new int[11][11];
		array[1][2] = 1;
		array[2][3] = 2;
		//System.out.println(array[0][0]);
		
		int count = 0;
		for(int[] row: array) {
			for(int data : row) {
				
				System.out.printf("%d\t", data);
				if(data != 0)
					count++;
				
			}
			System.out.println();
		}
		
		
		
		
		
		int[][] spareArray = new int[count+1][3];
		
		
		int r = array.length;
		int l = array[0].length;
		spareArray[0][0] = r;
		spareArray[0][1] = l;
		spareArray[0][2] = count;
		count = 0;
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<l; j++) {
				if(array[i][j] != 0) {
					count++;
					spareArray[count][0] = i;
					spareArray[count][1] = j;
					spareArray[count][2] = array[i][j];
				}
			}
		}
		
		System.out.println();
		System.out.println();
		
		for(int[] row : spareArray) {
			for(int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		
		// Ï¡Êè×ªÊı×é
		
		r = spareArray[0][0];
		l = spareArray[0][1];
		int[][] array2 = new int[r][l];
		
		for(int i=1; i <= spareArray[0][2]; i++) {
			array2[spareArray[i][0]][spareArray[i][1]] = spareArray[i][2];
			
		}
		
		System.out.println();
		System.out.println();
		
		for(int[] row: array2) {
			for(int data : row) {
				
				System.out.printf("%d\t", data);
				
			}
			System.out.println();
		}
		
		
		

	}

}
