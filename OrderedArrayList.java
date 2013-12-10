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
    public OrderedArrayList() {
	_data = (Comparable) new ArrayList();
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
    public void addLinear(Comparable newVal) { 
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
    public void addBinary(Comparable newVal) { 
        int mid = (_data.size()/2);
	while ( ( mid - 1 >= 0 )
		||
		( mid + 1 < _data.size() )
		||
		(  (  newVal.compareTo(_data.get(mid)) < 0 ) &&
		   (  newVal.compareTo(_data.get(mid - 1)) < 0 ) )
		||
		(  (  newVal.compareTo(_data.get(mid)) > 0 ) &&
		   (  newVal.compareTo(_data.get(mid + 1)) > 0 ) ) ) {

	    if  (  newVal.compareTo(_data.get(mid)) < 0 ) {
		mid = mid - (mid * 0.5);
	    }
	    else if (  newVal.compareTo(_data.get(mid)) > 0 ) {
		mid = mid + (mid * 0.5);
	    }
	}
	if ( mid - 1 < 0) {
	    _data.add(0, newVal);
	}
	else if ( mid + 1 >= _data.size() ) {
	    _data.add(newVal);
	}
	else if ( newVal.compareTo(_data.get(mid - 1)) > 0 ) {
	    _data.add(mid, newVal);
	}
	else if ( newVal.compareTo(_data.get(mid + 1)) < 0 ) {
	    _data.add( mid + 1, newVal);
	}
    }	    
	

    // main method solely for testing purposes
    public static void main( String[] args ) {


	OrderedArrayList Franz = new OrderedArrayList();

	// testing linear search
	for( int i = 0; i < 15; i++ )
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
