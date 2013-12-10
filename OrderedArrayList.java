//BENEDICT BOLTON
// HW#40
// PD08
// 2013-12-10

/*============================================
   class OrderedArrayList
   Wrapper class for ArrayList.
   Imposes the restriction that stored items 
   must remain sorted in ascending order
   ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;


public class OrderedArrayList {

    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList() { //O_O wow. These be simple...
	_data =  new ArrayList();
    }


    public String toString() { 
	return _data.toString();
    }


    public Comparable remove( int index ) { 
	return _data.remove(index);
    }


    public int size() { 
	return _data.size();
    }

    
    public Comparable get( int index ) { 
	return _data.get(index);
    }


    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear(Comparable newVal) {  //:C why must this be the one that uses more memory, the code is sooo much simpler, damn math...
	for( int k = 0; k < _data.size(); k ++) {
	    if (newVal.compareTo( _data.get(k) ) < 0) { 
		_data.add( k, newVal );
	    }
	}
	_data.add( newVal );
    }


    // addBinary takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a binary search to find appropriate index
    public void addBinary(Comparable newVal) {  //D: this is not simple
        int mid = (_data.size()/2);
	while ( ( ( mid - 1 >= 0 ) //catching for when it is the lowest new element
		  &&
		  ( mid + 1 < _data.size() ) ) //catching for when it is the highest new element
		&&
		( (  (  newVal.compareTo(_data.get(mid)) < 0 ) && //tests if element fits in a spot, ie is between +-1 of mid, if it isnt than one must move on
		     (  newVal.compareTo(_data.get(mid - 1)) < 0 ) )
		  ||
		  (  (  newVal.compareTo(_data.get(mid)) > 0 ) &&
		     (  newVal.compareTo(_data.get(mid + 1)) > 0 ) ) ) ) {

	    if  (  newVal.compareTo(_data.get(mid)) < 0 ) { 
		mid = mid - (mid/2); //updates mid for when newVal is less than _data[mid]
	    }
	    else if (  newVal.compareTo(_data.get(mid)) > 0 ) {
		mid = mid + (mid/2); //updates mid for when newVal is more than _data[mid]
	    }
	}
	if ( mid - 1 < 0) {
	    _data.add(0, newVal); //same as first catch
	}
	else if ( mid + 1 >= _data.size() ) {
	    _data.add(newVal); //same as 2nd catch
	}
	else if ( newVal.compareTo(_data.get(mid - 1)) > 0 ) {
	    _data.add(mid, newVal); //inserts newVal between mid and one less than mid
	}
	else if ( newVal.compareTo(_data.get(mid + 1)) < 0 ) {
	    _data.add( mid + 1, newVal); //inserts newVal between mid and one more than mid
	}
    }
	

    // main method solely for testing purposes
    public static void main( String[] args ) {


	OrderedArrayList Franz = new OrderedArrayList();
	
	// testing linear search
	for( int i = 0; i < 15; i++ )
	    System.out.println(Franz.size());
	    Franz.addLinear( (int)( 50 * Math.random() ) );
	System.out.println( Franz );

	// testing binary search
	Franz = new OrderedArrayList();
	for( int i = 0; i < 15; i++ ) 
	    Franz.addBinary( (int)( 50 * Math.random() ) );
	System.out.println( Franz );

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class OrderedArrayList
