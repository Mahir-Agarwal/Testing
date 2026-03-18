public class Seg {

    public static void main(String[] args) {
        
    }
    
}
class Segment {

    void build (int i ,  int l , int r , int nums[] , int seg[]){

        if( l == r ){
            seg[i] = nums[l];
            return ;
        }
        int mid =  l + (r-l)/2;

        build(2*i+1, l, mid, nums, seg);
        build(2*i+2, mid+1, r, nums, seg);

        seg[i] = seg[2*i+1]+ seg[2*i+2];
    }

    int singleQ(int idx , int i , int l , int r , int nums [] , int seg[] ){

        if(l == r) return seg[i];

        int mid = l + (r-l)/2;

        if( idx <= mid ){
            return singleQ(idx, 2*i+1, l, mid, nums, seg) ; 
        }
        return singleQ(idx, 2*i+2, mid+1, r, nums, seg);
    } 

    void rangeUpdate(int s , int e , int val , int i , int l , int r , int seg[] , int lazy[]){

        if(lazy[i]!=0){
            seg[i] += (r-l+1)* lazy[i];
            
            if( l !=r){

                lazy[2*i+1 ] += lazy[i];
                lazy[2*i+2 ] += lazy[i];
            }
            lazy[i] = 0;
            
        }
        if(l > e || r <s) return;
        if( l >= s && r <= e){

            seg[i] += (r-l+1) * val;

            if( l!=r){
                lazy[2*i+1] +=val;
                lazy[2*i+2] +=val;
            }

            return ;
            
        }

        int mid = l + (r-l)/2;

        rangeUpdate(s, e, val, 2*i+1, l, mid, seg, lazy);
        rangeUpdate(s, e, val, 2*i+2,mid+1,r, seg, lazy);

        seg[i] = seg[2*i+1] + seg[2*i+2];
    }

    int rangeQ(int s , int e ,int i , int l ,int r , int seg[] , int lazy []){

        if(lazy[i] != 0){
        seg[i] += (r-l+1) * lazy[i];

        if(l != r){
            lazy[2*i+1] += lazy[i];
            lazy[2*i+2] += lazy[i];
        }
        lazy[i] = 0;
        }

        if( l >e || r < s) return 0; 
        if( l >= s && r <= e ) return seg[i];

        int mid = l + (r-l)/2;

        return rangeQ(s, e, 2*i+1, l, mid, seg, lazy) + rangeQ(s, e, 2*i+2, mid+1, r, seg, lazy);
    }
}
