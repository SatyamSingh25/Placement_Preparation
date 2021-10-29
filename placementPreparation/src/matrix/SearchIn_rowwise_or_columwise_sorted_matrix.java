package matrix;
/**
 * @Search_Element_In_row_wise_or_column_wise_sorted_matrix
 * @Three_Condtions
 * @InterviewQuestion
 */
public class SearchIn_rowwise_or_columwise_sorted_matrix {
	
	public static boolean search(int[][] mat, int target) {
		int row = mat.length;
		int col = mat[0].length;
		
		int i=0, j=col-1;
		
		while(i<row && j>=0) {
			if(mat[i][j] == target){//if element found return true
				return true;
			}
			// if current element is greater than the target element
			// then this means "there is no meaning to find element in that column because all element is also greater than target value"
			//so just decrement J value (column value) else increase I value (row value)
			if(mat[i][j] > target) {
				j--;
			}
			else {
				i++;
			}
		}
		return false;//if element is not found
	}
	
	//Driver Code
	public static void main(String[] args) {
		int[][] mat = new int[][]	{{3, 30, 38},
            						{36, 43, 60},
            						{40, 51, 69}};
        //Element to be search
        int searchElement = 62;

        //function call
        System.out.println(searchElement + " is present: " + search(mat, searchElement)); //FALSE
        
        //Second Element to be search
        int searchElement2 = 43;

        //function call
        System.out.println(searchElement2 + " is present: " + search(mat, searchElement2)); //TRUE
        
	}
}
