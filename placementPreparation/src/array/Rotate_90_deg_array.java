package array;

public class Rotate_90_deg_array {

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
            	System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
		}
		//transpose of matrix
		for(int i=0; i<matrix.length; i++){
            for(int j=i+1; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
		System.out.println("Transpose:");
		for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
            	System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
		}
		//revering rows
		for(int i=0; i<matrix.length; i++){
            int start = 0;
            int end = matrix[0].length-1;
            while(start<end){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end]= temp;
                start++;
                end--;
            }
        } 
		System.out.println("90 deg rotated array");
		for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
            	System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
		}
	}

}
