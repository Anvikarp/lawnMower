import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        // variable initialization
        int trees;
        int tree_row;
        int tree_col;
        int numOfLawns;
        int mower_row = 0;
        int mower_column = 0;
        Lawn[] lawns;


        Scanner Sc = new Scanner(System.in);

        // number of lawns to mow
        System.out.println("How many lawns do you need Uncle Mo to mow?");
        numOfLawns = Sc.nextInt();
        Sc.nextLine();

        lawns = new Lawn[numOfLawns];

        // loop for getting user inputs of lawn_col and lawn_row for all lawns
        for(int i = 0; i < numOfLawns; i++)
        {
            // initialize variables for the column and row of the lawns
            int lawn_row = 100;
            int lawn_col = 100;

            // make sure it's less than 40
            while(lawn_row > 40)
            {
                System.out.println("Input the number of rows in the lawn "+(i+1));
                lawn_row = Sc.nextInt();
                Sc.nextLine();

                if (lawn_row > 40)
                {
                    System.out.println("Please enter the number of rows less than or equal to 40");
                }
            }

            while(lawn_col > 40)
            {
                System.out.println("Input the number of columns in the lawn "+(i+1));
                lawn_col = Sc.nextInt();
                Sc.nextLine();
                if (lawn_col > 40)
                {
                    System.out.println("Please enter the number of columns less than or equal to 40");
                }
            }
            // puts it in the array
            lawns[i] = new Lawn(lawn_row, lawn_col);
        }

        // fill the uncut lawn with dots
        for(int i = 0; i < numOfLawns; i++)
        {
            lawns[i].fillDotsforUncutLawn();
        }

        // put trees in the lawn completely randomly
        for(int i = 0; i < numOfLawns; i++)
        {

            //hardcoded values for testing
//             lawns[i].plantTrees(5,0);
//             lawns[i].plantTrees(0,3);
//             lawns[i].plantTrees(10,3);
//             lawns[i].plantTrees(1,4);
//             lawns[i].plantTrees(4,4);
//             lawns[i].plantTrees(10,6);
//             lawns[i].plantTrees(4,7);
//             lawns[i].plantTrees(9,7);
//             lawns[i].plantTrees(3,8);
//             lawns[i].plantTrees(8,8);
//             lawns[i].plantTrees(0,12);
//             lawns[i].plantTrees(7,12);

            trees = (int) (Math.random()*lawns[i].getRow()-1)+5;
            for(int j = 0; j < trees; j++)
            {
                tree_row = (int) (Math.random()*lawns[i].getRow()-1);
                tree_col = (int) (Math.random()*lawns[i].getColumn()*1);
                lawns[i].plantTrees(tree_row,tree_col);
            }

            //displaying the lawns before mowing
            System.out.println("Lawn number "+(i+1)+" before mowing:");
            lawns[i].displayLawn();
            System.out.println("");
        }

        //loop for asking for the starting point of the lawn mower
        for(int i = 0; i < numOfLawns; i++)
        {
            System.out.println("Which row number will the mower start at for Lawn #"+(i+1));
            mower_row = Sc.nextInt();
            Sc.nextLine();

            System.out.println("Which column number will the mower start at for Lawn #"+(i+1));
            mower_column = Sc.nextInt();
            Sc.nextLine();

            //identify and cut the grass
            lawns[i].mowTheLawn(mower_row, mower_column);
        }

        //display the lawn after mowing
        for(int i = 0; i < numOfLawns; i++)
        {
            System.out.println("Lawn #"+(i+1)+" after mowing:");
            lawns[i].displayLawn();
        }
    }
}