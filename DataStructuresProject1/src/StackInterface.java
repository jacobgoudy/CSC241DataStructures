interface StackInterface<E>{
public boolean empty();
/* returns true if the stack is empty; otherwise, 
   returns false
 */

public E peek();
/* returns the object E at the top of the stack
   without moving it.
   retains the original stack without any change.
 */
 
public E pop();
/* retruns the object E at the top of the stack
   and removes it.
   is different from peek(). 
 */
 
public E push(E item);
/* Saves an item E onto the top of the stack and 
   returns the item pushed.
 */
}