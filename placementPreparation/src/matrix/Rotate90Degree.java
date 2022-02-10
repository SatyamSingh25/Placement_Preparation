package matrix;
/**
 * @Matrix_90_rotation_Clockwise
 * @matrix *
 */
public class Rotate90Degree {
	public static int[][] rotate90Degree(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;
		for(int i=0; i<row; i++) {
			for(int j=i+1; j<col; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}																					
		//reversing 2D matrix row-wise
		for(int i=0; i<row; i++) {
			int start = 0;
			int end = mat[i].length-1;
			while(start < end) {
				int temp = mat[i][start];
				mat[i][start] = mat[i][end];
				mat[i][end] = temp;
				start++;
				end--;
			}
		}
		return mat;
	}
	public static void main(String[] args) {
		int[][] mat = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("Before rotation:");
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[i].length; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("after rotation:");
		mat = rotate90Degree(mat);
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[i].length; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}

}
