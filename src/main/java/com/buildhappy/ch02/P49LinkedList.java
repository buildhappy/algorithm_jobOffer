//package com.buildhappy.ch02;
//
//import java.util.AbstractSequentialList;
//import java.util.Collection;
//import java.util.ConcurrentModificationException;
//import java.util.Deque;
//import java.util.Iterator;
//import java.util.List;
//import java.util.ListIterator;
//import java.util.NoSuchElementException;
//import java.util.Objects;
//import java.util.Spliterator;
//import java.util.Spliterators;
//import java.util.function.Consumer;
//
//
//public class P49LinkedList<E>
//    extends AbstractSequentialList<E>
//    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
//{
//    transient int size = 0;
//
//    /**
//     * Pointer to first node.
//     * Invariant: (first == null && last == null) ||
//     *            (first.prev == null && first.item != null)
//     */
//    transient Node<E> first;
//
//    /**
//     * Pointer to last node.
//     * Invariant: (first == null && last == null) ||
//     *  不变的    (last.next == null && last.item != null)
//     */
//    transient Node<E> last;
//
//    public P49LinkedList() {
//    }
//
//    public P49LinkedList(Collection<? extends E> c) {
//        this();
//        addAll(c);
//    }
//
//    /**
//     * 在头节点插入元素
//     */
//    private void linkFirst(E e) {
//        final Node<E> f = first;
//        final Node<E> newNode = new Node<E>(null, e, f);
//        first = newNode;
//        if (f == null)
//            last = newNode;
//        else
//            f.prev = newNode;
//        size++;
//        modCount++;
//    }
//
//    public static void main(String[] args){
//    	P49LinkedList<String> list = new P49LinkedList<String>();
//    	list.linkFirst("aa");
//    	System.out.println(list.remove());
//    }
//
//    /**
//     * Links e as last element.
//     */
//    void linkLast(E e) {
//        final Node<E> l = last;
//        final Node<E> newNode = new Node<E>(l, e, null);
//        last = newNode;
//        if (l == null)
//            first = newNode;
//        else
//            l.next = newNode;
//        size++;
//        modCount++;
//    }
//
//    /**
//     * Inserts element e before non-null Node succ.
//     */
//    void linkBefore(E e, Node<E> succ) {
//        // assert succ != null;
//        final Node<E> pred = succ.prev;
//        final Node<E> newNode = new Node<E>(pred, e, succ);
//        succ.prev = newNode;
//        if (pred == null)
//            first = newNode;
//        else
//            pred.next = newNode;
//        size++;
//        modCount++;
//    }
//
//    /**
//     * Unlinks non-null first node f.
//     * 删除头节点
//     */
//    private E unlinkFirst(Node<E> f) {
//        // assert f == first && f != null;
//        final E element = f.item;
//        final Node<E> next = f.next;
//        f.item = null;
//        f.next = null; // help GC
//        first = next;
//        if (next == null)
//            last = null;
//        else
//            next.prev = null;
//        size--;
//        modCount++;
//        return element;
//    }
//
//    /**
//     * Unlinks non-null last node l.
//     * 删除最后一个节点
//     */
//    private E unlinkLast(Node<E> l) {
//        // assert l == last && l != null;
//        final E element = l.item;
//        final Node<E> prev = l.prev;
//        l.item = null;
//        l.prev = null; // help GC
//        last = prev;
//        if (prev == null)
//            first = null;
//        else
//            prev.next = null;
//        size--;
//        modCount++;
//        return element;
//    }
//
//    /**
//     * Unlinks non-null node x.
//     * 删除节点x
//     */
//    E unlink(Node<E> x) {
//        // assert x != null;
//        final E element = x.item;
//        final Node<E> next = x.next;
//        final Node<E> prev = x.prev;
//
//        if (prev == null) {
//            first = next;
//        } else {
//            prev.next = next;
//            x.prev = null;
//        }
//
//        if (next == null) {
//            last = prev;
//        } else {
//            next.prev = prev;
//            x.next = null;
//        }
//
//        x.item = null;
//        size--;
//        modCount++;
//        return element;
//    }
//
//    /**
//     * Returns the first element in this list.
//     */
//    public E getFirst() {
//        final Node<E> f = first;
//        if (f == null)
//            throw new NoSuchElementException();
//        return f.item;
//    }
//
//    /**
//     * Returns the last element in this list.
//     */
//    public E getLast() {
//        final Node<E> l = last;
//        if (l == null)
//            throw new NoSuchElementException();
//        return l.item;
//    }
//
//    /**
//     * Removes and returns the first element from this list.
//     */
//    public E removeFirst() {
//        final Node<E> f = first;
//        if (f == null)
//            throw new NoSuchElementException();
//        return unlinkFirst(f);
//    }
//
//    /**
//     * Removes and returns the last element from this list.
//     */
//    public E removeLast() {
//        final Node<E> l = last;
//        if (l == null)
//            throw new NoSuchElementException();
//        return unlinkLast(l);
//    }
//
//    /**
//     * Inserts the specified element at the beginning of this list.
//     */
//    public void addFirst(E e) {
//        linkFirst(e);
//    }
//
//    /**
//     * Appends the specified element to the end of this list.
//     *
//     * <p>This method is equivalent to {@link #add}.
//     *
//     * @param e the element to add
//     */
//    public void addLast(E e) {
//        linkLast(e);
//    }
//
//    public boolean contains(Object o) {
//        return indexOf(o) != -1;
//    }
//
//    public boolean add(E e) {
//        linkLast(e);
//        return true;
//    }
//
//    public boolean remove(Object o) {
//        if (o == null) {
//            for (Node<E> x = first; x != null; x = x.next) {
//                if (x.item == null) {
//                    unlink(x);
//                    return true;
//                }
//            }
//        } else {
//            for (Node<E> x = first; x != null; x = x.next) {
//                if (o.equals(x.item)) {
//                    unlink(x);
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public boolean addAll(Collection<? extends E> c) {
//        return addAll(size, c);
//    }
//
//    public boolean addAll(int index, Collection<? extends E> c) {
//        checkPositionIndex(index);//检查index是否合法
//
//        Object[] a = c.toArray();
//        int numNew = a.length;
//        if (numNew == 0)
//            return false;
//
//        Node<E> pred, succ;
//        if (index == size) {
//            succ = null;
//            pred = last;
//        } else {
//            succ = node(index);//获取第index个节点
//            pred = succ.prev;
//        }
//
//        for (Object o : a) {
//            @SuppressWarnings("unchecked") E e = (E) o;
//            Node<E> newNode = new Node<E>(pred, e, null);//pre element next
//            if (pred == null)
//                first = newNode;
//            else
//                pred.next = newNode;
//            pred = newNode;
//        }
//
//        if (succ == null) {
//            last = pred;
//        } else {
//            pred.next = succ;
//            succ.prev = pred;
//        }
//
//        size += numNew;
//        modCount++;
//        return true;
//    }
//
//    public void clear() {
//        // Clearing all of the links between nodes is "unnecessary", but:
//        // - helps a generational GC if the discarded nodes inhabit
//        //   more than one generation
//        // - is sure to free memory even if there is a reachable Iterator
//        for (Node<E> x = first; x != null; ) {
//            Node<E> next = x.next;
//            x.item = null;
//            x.next = null;
//            x.prev = null;
//            x = next;
//        }
//        first = last = null;
//        size = 0;
//        modCount++;
//    }
//
//    // Positional Access Operations
//    public E get(int index) {
//        checkElementIndex(index);
//        return node(index).item;
//    }
//
//    /**
//     * Replaces the element at the specified position in this list with the
//     * specified element.
//     */
//    public E set(int index, E element) {
//        checkElementIndex(index);
//        Node<E> x = node(index);
//        E oldVal = x.item;
//        x.item = element;
//        return oldVal;
//    }
//
//    /**
//     * Inserts the specified element at the specified position in this list.
//     * Shifts the element currently at that position (if any) and any
//     * subsequent elements to the right (adds one to their indices).
//     */
//    public void add(int index, E element) {
//        checkPositionIndex(index);
//
//        if (index == size)
//            linkLast(element);
//        else
//            linkBefore(element, node(index));
//    }
//
//    /**
//     * Removes the element at the specified position in this list.  Shifts any
//     * subsequent elements to the left (subtracts one from their indices).
//     * Returns the element that was removed from the list.
//     */
//    public E remove(int index) {
//        checkElementIndex(index);
//        return unlink(node(index));
//    }
//
//    /**
//     * Tells if the argument is the index of an existing element.
//     */
//    private boolean isElementIndex(int index) {
//        return index >= 0 && index < size;
//    }
//
//    /**
//     * Tells if the argument is the index of a valid position for an
//     * iterator or an add operation.
//     */
//    private boolean isPositionIndex(int index) {
//        return index >= 0 && index <= size;
//    }
//
//    /**
//     * Constructs an IndexOutOfBoundsException detail message.
//     * Of the many possible refactorings of the error handling code,
//     * this "outlining" performs best with both server and client VMs.
//     */
//    private String outOfBoundsMsg(int index) {
//        return "Index: "+index+", Size: "+size;
//    }
//
//    private void checkElementIndex(int index) {
//        if (!isElementIndex(index))
//            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//    }
//
//    private void checkPositionIndex(int index) {
//        if (!isPositionIndex(index))
//            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//    }
//
//    /**
//     * Returns the (non-null) Node at the specified element index.
//     */
//    Node<E> node(int index) {
//        // assert isElementIndex(index);
//
//        if (index < (size >> 1)) {
//            Node<E> x = first;
//            for (int i = 0; i < index; i++)
//                x = x.next;
//            return x;
//        } else {
//            Node<E> x = last;
//            for (int i = size - 1; i > index; i--)
//                x = x.prev;
//            return x;
//        }
//    }
//
//    // Search Operations
//
//    /**
//     * Returns the index of the first occurrence of the specified element
//     * in this list, or -1 if this list does not contain the element.
//     * More formally, returns the lowest index {@code i} such that
//     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
//     * or -1 if there is no such index.
//     */
//    public int indexOf(Object o) {
//        int index = 0;
//        if (o == null) {
//            for (Node<E> x = first; x != null; x = x.next) {
//                if (x.item == null)
//                    return index;
//                index++;
//            }
//        } else {
//            for (Node<E> x = first; x != null; x = x.next) {
//                if (o.equals(x.item))
//                    return index;
//                index++;
//            }
//        }
//        return -1;
//    }
//
//    /**
//     * Returns the index of the last occurrence of the specified element
//     * in this list, or -1 if this list does not contain the element.
//     * More formally, returns the highest index {@code i} such that
//     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
//     * or -1 if there is no such index.
//     */
//    public int lastIndexOf(Object o) {
//        int index = size;
//        if (o == null) {
//            for (Node<E> x = last; x != null; x = x.prev) {
//                index--;
//                if (x.item == null)
//                    return index;
//            }
//        } else {
//            for (Node<E> x = last; x != null; x = x.prev) {
//                index--;
//                if (o.equals(x.item))
//                    return index;
//            }
//        }
//        return -1;
//    }
//
//    /**
//     * Retrieves, but does not remove, the head (first element) of this list.
//     *
//     * @return the head of this list, or {@code null} if this list is empty
//     */
//    public E peek() {
//        final Node<E> f = first;
//        return (f == null) ? null : f.item;
//    }
//
//    public E element() {
//        return getFirst();
//    }
//
//    /**
//     * Retrieves and removes the head (first element) of this list.
//     */
//    public E poll() {
//        final Node<E> f = first;
//        return (f == null) ? null : unlinkFirst(f);
//    }
//
//    /**
//     * Retrieves and removes the head (first element) of this list.
//     */
//    public E remove() {
//        return removeFirst();
//    }
//
//    /**
//     * Adds the specified element as the tail (last element) of this list.
//     */
//    public boolean offer(E e) {
//        return add(e);
//    }
//
//    // Deque operations(双向队列)
//    public boolean offerFirst(E e) {
//        addFirst(e);
//        return true;
//    }
//
//    public boolean offerLast(E e) {
//        addLast(e);
//        return true;
//    }
//    public E peekFirst() {
//        final Node<E> f = first;
//        return (f == null) ? null : f.item;
//     }
//
//    /**
//     * Retrieves, but does not remove, the last element of this list,
//     */
//    public E peekLast() {
//        final Node<E> l = last;
//        return (l == null) ? null : l.item;
//    }
//
//    /**
//     * Retrieves and removes the first element of this list,
//     * or returns {@code null} if this list is empty.
//     */
//    public E pollFirst() {
//        final Node<E> f = first;
//        return (f == null) ? null : unlinkFirst(f);
//    }
//
//    public E pollLast() {
//        final Node<E> l = last;
//        return (l == null) ? null : unlinkLast(l);
//    }
//
//    /**
//     * Pushes an element onto the stack represented by this list.  In other
//     * words, inserts the element at the front of this list.
//     *
//     * <p>This method is equivalent to {@link #addFirst}.
//     */
//    public void push(E e) {
//        addFirst(e);
//    }
//
//    /**
//     * Pops an element from the stack represented by this list.  In other
//     * words, removes and returns the first element of this list.
//     */
//    public E pop() {
//        return removeFirst();
//    }
//
//    /**
//     * Removes the first occurrence of the specified element in this
//     * list (when traversing the list from head to tail).  If the list
//     * does not contain the element, it is unchanged.
//     */
//    public boolean removeFirstOccurrence(Object o) {
//        return remove(o);
//    }
//
//    /**
//     * Removes the last occurrence of the specified element in this
//     * list (when traversing the list from head to tail).  If the list
//     * does not contain the element, it is unchanged.
//     */
//    public boolean removeLastOccurrence(Object o) {
//        if (o == null) {
//            for (Node<E> x = last; x != null; x = x.prev) {
//                if (x.item == null) {
//                    unlink(x);
//                    return true;
//                }
//            }
//        } else {
//            for (Node<E> x = last; x != null; x = x.prev) {
//                if (o.equals(x.item)) {
//                    unlink(x);
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    /**
//     * Returns a list-iterator of the elements in this list (in proper
//     * sequence), starting at the specified position in the list.
//     * Obeys the general contract of {@code List.listIterator(int)}.<p>
//     *
//     * The list-iterator is <i>fail-fast</i>: if the list is structurally
//     * modified at any time after the Iterator is created, in any way except
//     * through the list-iterator's own {@code remove} or {@code add}
//     * methods, the list-iterator will throw a
//     * {@code ConcurrentModificationException}.  Thus, in the face of
//     * concurrent modification, the iterator fails quickly and cleanly, rather
//     * than risking arbitrary, non-deterministic behavior at an undetermined
//     * time in the future.
//     *
//     * @param index index of the first element to be returned from the
//     *              list-iterator (by a call to {@code next})
//     * @return a ListIterator of the elements in this list (in proper
//     *         sequence), starting at the specified position in the list
//     * @throws IndexOutOfBoundsException {@inheritDoc}
//     * @see List#listIterator(int)
//     */
//    public ListIterator<E> listIterator(int index) {
//        checkPositionIndex(index);
//        return new ListItr(index);
//    }
//
//    private class ListItr implements ListIterator<E> {
//        private Node<E> lastReturned;
//        private Node<E> next;
//        private int nextIndex;
//        private int expectedModCount = modCount;
//
//        ListItr(int index) {
//            // assert isPositionIndex(index);
//            next = (index == size) ? null : node(index);
//            nextIndex = index;
//        }
//
//        public boolean hasNext() {
//            return nextIndex < size;
//        }
//
//        public E next() {
//            checkForComodification();
//            if (!hasNext())
//                throw new NoSuchElementException();
//
//            lastReturned = next;
//            next = next.next;
//            nextIndex++;
//            return lastReturned.item;
//        }
//
//        public boolean hasPrevious() {
//            return nextIndex > 0;
//        }
//
//        public E previous() {
//            checkForComodification();
//            if (!hasPrevious())
//                throw new NoSuchElementException();
//
//            lastReturned = next = (next == null) ? last : next.prev;
//            nextIndex--;
//            return lastReturned.item;
//        }
//
//        public int nextIndex() {
//            return nextIndex;
//        }
//
//        public int previousIndex() {
//            return nextIndex - 1;
//        }
//
//        public void remove() {
//            checkForComodification();
//            if (lastReturned == null)
//                throw new IllegalStateException();
//
//            Node<E> lastNext = lastReturned.next;
//            unlink(lastReturned);
//            if (next == lastReturned)
//                next = lastNext;
//            else
//                nextIndex--;
//            lastReturned = null;
//            expectedModCount++;
//        }
//
//        public void set(E e) {
//            if (lastReturned == null)
//                throw new IllegalStateException();
//            checkForComodification();
//            lastReturned.item = e;
//        }
//
//        public void add(E e) {
//            checkForComodification();
//            lastReturned = null;
//            if (next == null)
//                linkLast(e);
//            else
//                linkBefore(e, next);
//            nextIndex++;
//            expectedModCount++;
//        }
//
//        public void forEachRemaining(Consumer<? super E> action) {
//            Objects.requireNonNull(action);
//            while (modCount == expectedModCount && nextIndex < size) {
//                action.accept(next.item);
//                lastReturned = next;
//                next = next.next;
//                nextIndex++;
//            }
//            checkForComodification();
//        }
//
//        final void checkForComodification() {
//            if (modCount != expectedModCount)
//                throw new ConcurrentModificationException();
//        }
//    }
//
//    private static class Node<E> {
//        E item;
//        Node<E> next;
//        Node<E> prev;
//
//        Node(Node<E> prev, E element, Node<E> next) {
//            this.item = element;
//            this.next = next;
//            this.prev = prev;
//        }
//    }
//
//    public Iterator<E> descendingIterator() {
//        return new DescendingIterator();
//    }
//
//    /**
//     * Adapter to provide descending iterators via ListItr.previous
//     */
//    private class DescendingIterator implements Iterator<E> {
//        private final ListItr itr = new ListItr(size());
//        public boolean hasNext() {
//            return itr.hasPrevious();
//        }
//        public E next() {
//            return itr.previous();
//        }
//        public void remove() {
//            itr.remove();
//        }
//    }
//
//    @SuppressWarnings("unchecked")
//    private P49LinkedList<E> superClone() {
//        try {
//            return (P49LinkedList<E>) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new InternalError(e);
//        }
//    }
//
//    /**
//     * Returns a shallow copy of this {@code LinkedList}. (The elements
//     * themselves are not cloned.)
//     *
//     * @return a shallow copy of this {@code LinkedList} instance
//     */
//    public Object clone() {
//        P49LinkedList<E> clone = superClone();
//
//        // Put clone into "virgin" state
//        clone.first = clone.last = null;
//        clone.size = 0;
//        clone.modCount = 0;
//
//        // Initialize clone with our elements
//        for (Node<E> x = first; x != null; x = x.next)
//            clone.add(x.item);
//
//        return clone;
//    }
//
//    /**
//     * Returns an array containing all of the elements in this list
//     * in proper sequence (from first to last element).
//     *
//     * <p>The returned array will be "safe" in that no references to it are
//     * maintained by this list.  (In other words, this method must allocate
//     * a new array).  The caller is thus free to modify the returned array.
//     *
//     * <p>This method acts as bridge between array-based and collection-based
//     * APIs.
//     *
//     * @return an array containing all of the elements in this list
//     *         in proper sequence
//     */
//    public Object[] toArray() {
//        Object[] result = new Object[size];
//        int i = 0;
//        for (Node<E> x = first; x != null; x = x.next)
//            result[i++] = x.item;
//        return result;
//    }
//
//    /**
//     * Returns an array containing all of the elements in this list in
//     * proper sequence (from first to last element); the runtime type of
//     * the returned array is that of the specified array.  If the list fits
//     * in the specified array, it is returned therein.  Otherwise, a new
//     * array is allocated with the runtime type of the specified array and
//     * the size of this list.
//     *
//     * <p>If the list fits in the specified array with room to spare (i.e.,
//     * the array has more elements than the list), the element in the array
//     * immediately following the end of the list is set to {@code null}.
//     * (This is useful in determining the length of the list <i>only</i> if
//     * the caller knows that the list does not contain any null elements.)
//     *
//     * <p>Like the {@link #toArray()} method, this method acts as bridge between
//     * array-based and collection-based APIs.  Further, this method allows
//     * precise control over the runtime type of the output array, and may,
//     * under certain circumstances, be used to save allocation costs.
//     *
//     * <p>Suppose {@code x} is a list known to contain only strings.
//     * The following code can be used to dump the list into a newly
//     * allocated array of {@code String}:
//     *
//     * <pre>
//     *     String[] y = x.toArray(new String[0]);</pre>
//     *
//     * Note that {@code toArray(new Object[0])} is identical in function to
//     * {@code toArray()}.
//     *
//     * @param a the array into which the elements of the list are to
//     *          be stored, if it is big enough; otherwise, a new array of the
//     *          same runtime type is allocated for this purpose.
//     * @return an array containing the elements of the list
//     * @throws ArrayStoreException if the runtime type of the specified array
//     *         is not a supertype of the runtime type of every element in
//     *         this list
//     */
//    @SuppressWarnings("unchecked")
//    public <T> T[] toArray(T[] a) {
//        if (a.length < size)
//            a = (T[])java.lang.reflect.Array.newInstance(
//                                a.getClass().getComponentType(), size);
//        int i = 0;
//        Object[] result = a;
//        for (Node<E> x = first; x != null; x = x.next)
//            result[i++] = x.item;
//
//        if (a.length > size)
//            a[size] = null;
//
//        return a;
//    }
//
//    private static final long serialVersionUID = 876323262645176354L;
//
//    /**
//     * Saves the state of this {@code LinkedList} instance to a stream
//     * (that is, serializes it).
//     *
//     * @serialData The size of the list (the number of elements it
//     *             contains) is emitted (int), followed by all of its
//     *             elements (each an Object) in the proper order.
//     */
//    private void writeObject(java.io.ObjectOutputStream s)
//        throws java.io.IOException {
//        // Write out any hidden serialization magic
//        s.defaultWriteObject();
//
//        // Write out size
//        s.writeInt(size);
//
//        // Write out all elements in the proper order.
//        for (Node<E> x = first; x != null; x = x.next)
//            s.writeObject(x.item);
//    }
//
//    /**
//     * Reconstitutes this {@code LinkedList} instance from a stream
//     * (that is, deserializes it).
//     */
//    @SuppressWarnings("unchecked")
//    private void readObject(java.io.ObjectInputStream s)
//        throws java.io.IOException, ClassNotFoundException {
//        // Read in any hidden serialization magic
//        s.defaultReadObject();
//
//        // Read in size
//        int size = s.readInt();
//
//        // Read in all elements in the proper order.
//        for (int i = 0; i < size; i++)
//            linkLast((E)s.readObject());
//    }
//
//    /**
//     * Creates a <em><a href="Spliterator.html#binding">late-binding</a></em>
//     * and <em>fail-fast</em> {@link Spliterator} over the elements in this
//     * list.
//     *
//     * <p>The {@code Spliterator} reports {@link Spliterator#SIZED} and
//     * {@link Spliterator#ORDERED}.  Overriding implementations should document
//     * the reporting of additional characteristic values.
//     *
//     * @implNote
//     * The {@code Spliterator} additionally reports {@link Spliterator#SUBSIZED}
//     * and implements {@code trySplit} to permit limited parallelism..
//     *
//     * @return a {@code Spliterator} over the elements in this list
//     * @since 1.8
//     */
//    public Spliterator<E> spliterator() {
//        return new LLSpliterator<E>(this, -1, 0);
//    }
//
//    /** A customized variant of Spliterators.IteratorSpliterator */
//    static final class LLSpliterator<E> implements Spliterator<E> {
//        static final int BATCH_UNIT = 1 << 10;  // batch array size increment
//        static final int MAX_BATCH = 1 << 25;  // max batch array size;
//        final P49LinkedList<E> list; // null OK unless traversed
//        Node<E> current;      // current node; null until initialized
//        int est;              // size estimate; -1 until first needed
//        int expectedModCount; // initialized when est set
//        int batch;            // batch size for splits
//
//        LLSpliterator(P49LinkedList<E> list, int est, int expectedModCount) {
//            this.list = list;
//            this.est = est;
//            this.expectedModCount = expectedModCount;
//        }
//
//        final int getEst() {
//            int s; // force initialization
//            final P49LinkedList<E> lst;
//            if ((s = est) < 0) {
//                if ((lst = list) == null)
//                    s = est = 0;
//                else {
//                    expectedModCount = lst.modCount;
//                    current = lst.first;
//                    s = est = lst.size;
//                }
//            }
//            return s;
//        }
//
//        public long estimateSize() { return (long) getEst(); }
//
//        public Spliterator<E> trySplit() {
//            Node<E> p;
//            int s = getEst();
//            if (s > 1 && (p = current) != null) {
//                int n = batch + BATCH_UNIT;
//                if (n > s)
//                    n = s;
//                if (n > MAX_BATCH)
//                    n = MAX_BATCH;
//                Object[] a = new Object[n];
//                int j = 0;
//                do { a[j++] = p.item; } while ((p = p.next) != null && j < n);
//                current = p;
//                batch = j;
//                est = s - j;
//                return Spliterators.spliterator(a, 0, j, Spliterator.ORDERED);
//            }
//            return null;
//        }
//
//        public void forEachRemaining(Consumer<? super E> action) {
//            Node<E> p; int n;
//            if (action == null) throw new NullPointerException();
//            if ((n = getEst()) > 0 && (p = current) != null) {
//                current = null;
//                est = 0;
//                do {
//                    E e = p.item;
//                    p = p.next;
//                    action.accept(e);
//                } while (p != null && --n > 0);
//            }
//            if (list.modCount != expectedModCount)
//                throw new ConcurrentModificationException();
//        }
//
//        public boolean tryAdvance(Consumer<? super E> action) {
//            Node<E> p;
//            if (action == null) throw new NullPointerException();
//            if (getEst() > 0 && (p = current) != null) {
//                --est;
//                E e = p.item;
//                current = p.next;
//                action.accept(e);
//                if (list.modCount != expectedModCount)
//                    throw new ConcurrentModificationException();
//                return true;
//            }
//            return false;
//        }
//
//        public int characteristics() {
//            return Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
//        }
//    }
//
//	@Override
//	public int size() {
//		return size;
//	}
//}
