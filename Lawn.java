import java.util.ArrayList;

public class Lawn {

    private int row;
    private int column;
    private String[][] Lawn;

    private int mowerRow;

    private int mowerColumn;

    public Lawn(){
        row = 0;
        column = 0;
        mowerRow = 0;
        mowerColumn = 0;
    }

    public Lawn(int row, int column){
        this.row = row;
        this.column = column;
        Lawn = new String[row][column];
    }
    public int getRow()
    {
        return row;
    }

    public int getColumn()
    {
        return column;
    }

    public int getMowerRow(){
        return mowerRow;
    }

    public int getMowerColumn(){
        return mowerColumn;
    }

    public void setRow(int r)
    {
        row = r;
    }

    public void setColumn(int c)
    {
        column = c;
    }

    public void setMowerRow(int c){
        mowerRow = c;
    }

    public void setMowerColumn(int c){
        mowerColumn = c;
    }


    public void fillDotsforUncutLawn() {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    Lawn[i][j] = ".";
                }
            }
    }
    public void plantTrees(int r_num, int c_num) {
            Lawn[r_num][c_num] = "T";
    }

    public void displayLawn(){
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < column; j++)
            {
                System.out.print(Lawn[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    private boolean invalidSpotToMow(int startrow, int startcol)
    {
        if(startrow-1 < 0 || startcol-1 < 0 || startrow+1 > Lawn.length-1 ||  startcol+1 > Lawn[0].length-1)
        {
            return true;
        }
        else
        {
            if((Lawn[startrow-1][startcol-1].equals("T") || Lawn[startrow-1][startcol].equals("T") || Lawn[startrow-1][startcol+1].equals("T") ||
                    Lawn[startrow][startcol-1].equals("T") || Lawn[startrow][startcol].equals("T") || Lawn[startrow][startcol+1].equals("T") ||
                    Lawn[startrow+1][startcol-1].equals("T") || Lawn[startrow+1][startcol].equals("T") || Lawn[startrow+1][startcol+1].equals("T")) ||
                    (Lawn[startrow-1][startcol-1].equals("C") && Lawn[startrow-1][startcol].equals("C") && Lawn[startrow-1][startcol+1].equals("C") &&
                            Lawn[startrow][startcol-1].equals("C") && Lawn[startrow][startcol].equals("C") && Lawn[startrow][startcol+1].equals("C") &&
                            Lawn[startrow+1][startcol-1].equals("C") && Lawn[startrow+1][startcol].equals("C") && Lawn[startrow+1][startcol+1].equals("C")))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

    }
    public void mowTheLawn( int rnum, int cnum)
    {
        cutLawn(rnum, cnum);
    }

    private void cutLawn(int row_num, int col_num) {
        if (invalidSpotToMow(row_num, col_num)) {
            return;
        }

        Lawn[row_num - 1][col_num - 1] = "C";
        Lawn[row_num - 1][col_num] = "C";
        Lawn[row_num - 1][col_num + 1] = "C";
        Lawn[row_num][col_num - 1] = "C";
        Lawn[row_num][col_num] = "C";
        Lawn[row_num][col_num + 1] = "C";
        Lawn[row_num + 1][col_num - 1] = "C";
        Lawn[row_num + 1][col_num] = "C";
        Lawn[row_num + 1][col_num + 1] = "C";


        cutLawn(row_num - 1, col_num);
        cutLawn(row_num, col_num - 1);
        cutLawn(row_num, col_num + 1);
        cutLawn(row_num + 1, col_num);
    }
}
