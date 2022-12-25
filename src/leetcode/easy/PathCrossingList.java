package src.leetcode.easy;

public class PathCrossingList {

	 public boolean isPathCrossing(String path) {

		 int x=0,y=0;
		 for(int i=0;i<path.length();i++)
		 {
			
			 switch(path.charAt(i))
			 {
			 case 'N':
				 	if(isCrossing(x,++y))
				 		return true;
				 	break;
			 case 'S':
				 	if(isCrossing(x,--y))
				 		return true;

				 break;
			 case 'E':
				 	if(isCrossing(++x,y))
				 		return true;

				 break;
			 case 'W':
				 	if(isCrossing(--x,y))
				 		return true;

				 break;
			 }
		 }
		 return false;
	    }
	 public boolean isCrossing(int x,int y)
	 {
	 return x==0 && y==0;
	 }
	public static void main(String[] args)
	{
		PathCrossingList pathCross=new PathCrossingList();
		//System.out.println(pathCross.isPathCrossing("NSEW"));
		
		System.out.println(pathCross.isPathCrossing("NNSWWEWSSESSWENNW"));
	}
}
