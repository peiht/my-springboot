package org.spring.server.datastruct.list;

import java.util.*;

/**
 * @author hitopei
 * @param <E>
 *
 *
 */
public class ArrayListDemo<E> implements List<E> {

    private static final Object[] DEFAULTCAPACITY_EMPTY_ARRAY = {};
    private static int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public ArrayListDemo (){
        array = DEFAULTCAPACITY_EMPTY_ARRAY;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(array, size, a.getClass());
        }
        //将集合的内容复制到a上
        System.arraycopy(array, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        //确保当前数组长度够用
        ensureCapacityInternal(size + 1);
        array[size++] = e;
        return true;
    }

    public void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(array, minCapacity));
    }

    //计算扩容后的长度
    private static int calculateCapacity(Object[] array, int minCapacity) {
        //第一次扩容，申请长度为10
        if (array == DEFAULTCAPACITY_EMPTY_ARRAY) {
            return Math.max(minCapacity, DEFAULT_CAPACITY );
        }
        return minCapacity;
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - array.length > 0) {
            //扩容
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = array.length;
        //1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        //最大数组长度情况已经省略
        array = Arrays.copyOf(array, newCapacity);
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null){
                    fastRemove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])){
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    private void fastRemove(int index){
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--size] = null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object obj : c) {
            if (!contains(obj)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        rangeCheckForAdd(index);
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityInternal(size + numNew);

        int numMoved = size - index;
        if (numMoved > 0) {
            System.arraycopy(array, index, array, index + numNew, numMoved);
        }
        System.arraycopy(a, 0, array, index, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        return batchRemove(c, false);
    }

    private boolean batchRemove(Collection<?> c, boolean complement) {
        final Object[] data = this.array;
        int r = 0, w = 0;
        boolean modified = false;
        try {
            for (; r < size; r++) {
                if (c.contains(data[r]) == complement) {
                    data[w++] = data[r];
                }
            }
        } finally {
            if (r != size) {
                System.arraycopy(data, r, data, w, size - r);
                w += size - r;
            }

            if (w != size) {
                for (int i = w; i < size; i++) {
                    data[i] = null;
                }
                size = w;
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c);
        return batchRemove(c, true);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E) array[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E oldValue = (E) array[index];
        array[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacityInternal(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组长度不符合规范" + index);
        }
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("数组越界" + index);
        }
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        E oldValue = (E) array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--size] = null;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        //判断是否为null
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null){
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0 ; i--) {
                if (array[i] == null){
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        return "ArrayListDemo{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
