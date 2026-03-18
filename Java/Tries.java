
public class Tries { 
    public static void main(String[] args) {
        
       
        
    }


    static class Node{
    
        Node child[]  = new Node [26];
        boolean eow =false;
        Node(){
            for(int i =0 ; i<26 ; i++){
                child[i] = null ;
            }
        }
    
    }

    public static Node root = new Node();

    public static void insert(String word){


        Node curr  = root ;

        for(int i = 0   ; i < word.length() ; i++){

            int ch = word.charAt(i)-'a';
            if(curr.child[ch] == null){
                curr.child[ch] = new Node();
            }
            curr = curr.child[ch];
        }

        curr.eow = true;
    }

    public static boolean search(String word){

        Node curr = root ;

        for(int i = 0 ; i < word.length() ;i++){
            int ch = word.charAt(i)-'a';

            if(curr.child[ch] == null) return false;
            curr = curr.child[ch];
        }
        return curr.eow == true ? true : false;
    }
}

