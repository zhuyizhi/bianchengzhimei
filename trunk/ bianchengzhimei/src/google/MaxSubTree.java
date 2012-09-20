package google;

import java.util.Arrays;

/**
 * 给定一棵树，其中节点为正或负整数，求其和最大的子树。
 * @author ucai
 *
 */

public class MaxSubTree {
	
	public static int max = Integer.MIN_VALUE;
      public static int getSum(Tree root){
          int sum = root.val;
          int left = 0, right = 0;     
          if(root.left != null)
               left = getSum(root.left);
          if(root.right != null)
               right = getSum(root.right);

          if(left > 0)
               sum += left;
          if(right > 0)
               sum += right;

          root.sum = sum;
          if(sum > max)
        	  max = sum;
          return sum;
     }

      /**
       * 			-7
       * 	      /   \
       *        3     9
       *       / \     \
       *      -5  1    -4
       *               /
       *              5  
       * @param args
       */
     public static void main(String[] args){
//          int[] val = {-5, 3, 1, 5, 9, -1, -4};
//          int[] parent = {1, 3, 1, -1, 3, 6, 4};
          
          int[] val = {-5, 1, 3, 5, -4, 9, -7};
          int[] parent = {2, 2, 6, 4, 5, 6, -1};
          boolean[] isLeft = {true, false, true, true, false, false, true};
          
          Tree[] tree = new Tree[val.length];
          Arrays.fill(tree, null);
          for(int i = 0; i < val.length; i++){
        	  Tree left = null, right = null;
        	  for(int j = 0; j < val.length; j++){
        		  if(parent[j] == i){
        			  if(isLeft[j])
        				  left = tree[j];
        			  else
        				  right = tree[j];
        		  }
        	  }
        	  tree[i] = new Tree(val[i], left, right);
          }
          int sum = getSum(tree[tree.length - 1]);
          System.out.println(sum);
          System.out.println(max);
     }
}
class Tree{
        int sum ;
        int val ;
       Tree left ;
       Tree right ;
       public Tree(int val, Tree left, Tree right){
    	   this.val = val;
    	   this.left = left;
    	   this.right = right;
    	   this.sum = 0;
       }
       public Tree(int val){
    	   this(val, null, null);
       }
}
