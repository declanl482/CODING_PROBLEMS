class Solution {
    
    public boolean isValidBox(int row, int col, char[][] board) {
        Set<Character> boxSet = new HashSet<Character>();
        int boxRowEnd = row + 3;
        int boxColEnd = col + 3;
        
        // Check that the box does not contain any repeated values.
        for (int boxRow = row; boxRow < boxRowEnd; boxRow++) {
            for (int boxCol = col; boxCol < boxColEnd; boxCol++) {
                char cur = board[boxRow][boxCol];
                if (cur != '.') {
                    if (!boxSet.add(cur)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {

        Set<Character> rowSet = null;
        Set<Character> colSet = null;
        
        // Check that each row and column does not contain any repeated values.
        for (int row = 0; row < board.length; row++) {
            rowSet = new HashSet<Character>();
            colSet = new HashSet<Character>();
            
            for (int col = 0; col < board[row].length; col++) {
                char rowCur = board[row][col];
                char colCur = board[col][row];
                if (rowCur != '.') {
                    if (!rowSet.add(rowCur)) {
                        return false;
                    }
                }
                
                if (colCur != '.') {
                    if (!colSet.add(colCur)) {
                        return false;
                    }
                }
            }
        }
        
        // Check that each of the sub-boxes does not contain any repeated values.
        for (int boxRow = 0; boxRow < board.length; boxRow += 3) {
            for (int boxCol = 0; boxCol < board[boxRow].length; boxCol += 3) {
                if (!isValidBox(boxRow, boxCol, board)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}