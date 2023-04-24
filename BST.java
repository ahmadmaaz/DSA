import java.util.ArrayList;

public class BST <E extends Comparable<E>>{
    public BSTNode<E> root;

    public BST(){
        this.root=null;
    }

    public BST(BSTNode<E> node){
        this.root=node;
    }

    //Check if the tree is empty
    public boolean isEmpty(){
        return root==null;
    }

    public int size(){
        return sizeRec(root);
    }
    //Get the number of nodes in the tree
    private int sizeRec(BSTNode<E> node){
        if(node==null){
            return 0;
        }
        return  1+ sizeRec(node.left) + sizeRec(node.right);
    }

    public int height(){
        return heightRec(root);
    }
    //Get the height of tree
    private int heightRec(BSTNode<E> node){
        if(node==null){
            return 0;
        }
        return  1 + Math.max(heightRec(node.right),heightRec(node.left));
    }

    public boolean isBalanced(){
        int diff= Math.abs(heightRec(root.right)-heightRec(root.left));
        return diff==0 || diff==1;
    }

    public ArrayList<E> filterBST(E data){
        ArrayList<E> res= new ArrayList<>();
        filterBSTRec(root,res,data);
        return res;
    }

    public void filterBSTRec(BSTNode<E> node,ArrayList<E> arr, E data){
        if(node==null){
            return;
        }
        if(data.compareTo(node.data)==1) arr.add(node.data);
        filterBSTRec(node.left,arr,data);
        filterBSTRec(node.right,arr,data);
    }

    public void insert(E data){
        root= insertRec(root,data);
    }

    public BSTNode<E> insertRec(BSTNode<E> node, E data){
        if(node==null){
            node= new BSTNode<E>(data);
            return node;
        }
        if(data.compareTo(node.data)>0){
            node.right= insertRec(node.right,data);
        }else if (data.compareTo(node.data)<0){
            node.left= insertRec(node.left,data);
        }
        return node;
    }

    public boolean search(E data){
        return searchRec(root,data);
    }
    public boolean searchRec(BSTNode<E> node , E data){
        if(node==null){
            return false;
        }
        if(data.compareTo(node.data)==0){
            return true;
        }
        else if (data.compareTo(node.data)>0){
            return searchRec(node.right,data);
        }
        return searchRec(node.left,data);
    }


    public void delete(E data){
        deleteRec(root,data);
    }

    //Delete a specific node inside a tree
    public BSTNode<E> deleteRec(BSTNode<E> node,E data){

        if(data.compareTo(node.data)>0){
            node.right= deleteRec(node.right,data);
            return  node;
        }else if (data.compareTo(node.data) <0){
            node.left= deleteRec(node.left,data);
            return  node;
        }
        if(node.right==null && node.left==null){
            return null;
        }
        else if(node.right==null){
            return node.left;
        }
        else if(node.left==null){
            return node.right;
        }
        BSTNode<E> curr=node.right;
        while(curr.left!=null){
            curr=curr.left;
        }
        curr.left=node.left;
        return node.right;
    }


    //Check if the tree is leaf
    public boolean isLeaf(){
        return root.left==null && root.right==null && root.data!=null;
    }

    public void inorder() { //prints the tree in order
        inOrderRec(root);
    }
    //Traverse in inOrder
    private void inOrderRec(BSTNode<E> root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }
    public void preorder(){
        preOrderRec(root);
    }
    //Traverse in preOrder
    private  void  preOrderRec(BSTNode<E> root){
        if (root != null) {
            System.out.print(root.data + " ");
            inOrderRec(root.left);
            inOrderRec(root.right);
        }
    }

    public void postorder(){
        preOrderRec(root);
    }
    //Traverse inm postOrder
    private  void  postOrderRec(BSTNode<E> root){
        if (root != null) {
            inOrderRec(root.left);
            inOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    //Get the minimum data inside a BST
    public E getMinimum(){
        if(isEmpty()){
            return null;
        }
        BSTNode<E> curr= root;
        while(curr!=null && curr.left!=null){
            curr=curr.left;
        }
        return curr.data;
    }

    //Get the maximum data inside a BST
    public E getMaximum(){
        if(isEmpty()){
            return null;
        }
        BSTNode<E> curr= root;
        while(curr!=null && curr.right!=null){
            curr=curr.right;
        }
        return curr.data;
    }

    //OVERLOADING THE FUNCTION
    //Get the minimum data inside a BST
    public E getMinimum(BSTNode<E> node){
        if(node==null){
            return null;
        }
        BSTNode<E> curr= node;
        while(curr!=null && curr.left!=null){
            curr=curr.left;
        }
        return curr.data;
    }
    //OVERLOADING THE FUNCTION
    //Get the maximum data inside a BST
    public E getMaximum(BSTNode<E> node){
        if(node==null){
            return null;
        }
        BSTNode<E> curr= node;
        while(curr!=null && curr.right!=null){
            curr=curr.right;
        }
        return curr.data;
    }


    //Get next highest value for data
    public E successor(E data){
        BSTNode<E> curr=root;
        E successorData= curr.data;
        while(curr!=null){
            if(data.compareTo(curr.data) < 0){
                successorData=curr.data;
                curr=curr.left;
            }else{
                curr=curr.right;
            }
        }
        if(data.compareTo(successorData)!=-1){
            return null;
        }
        return successorData;
    }

    //Get the next lowest Value for data
    public E predecessor(E data){
        BSTNode<E> curr=root;
        E successorData= curr.data;
        while(curr!=null){
            if(data.compareTo(curr.data) <= 0){
                curr=curr.left;
            }else{
                successorData=curr.data;
                curr=curr.right;
            }
        }
        if(data.compareTo(successorData)!=1){
            return null;
        }
        return successorData;
    }

}


class BSTNode <E> {
    public E data;
    public BSTNode<E> right;
    public BSTNode<E> left;
    public  BSTNode(){

    }
    public BSTNode( E data){
        this.data=data;
        this.right=null;
        this.left=null;
    }

    @Override
    public String toString(){
        return data.toString();
    }
}
