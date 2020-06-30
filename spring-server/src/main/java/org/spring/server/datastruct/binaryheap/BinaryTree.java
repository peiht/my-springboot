package org.spring.server.datastruct.binaryheap;

/**
 * @author hitopei
 * 二叉堆的实现
 * 先实现大顶堆
 */
public class BinaryTree {

    private int[] array;
    private int size = 0;
    private static final int DEFAULT_SIZE = 10;
    public BinaryTree() {
        array = new int[DEFAULT_SIZE];
    }

    /**
     * 添加操作
     * @param val
     */
    public void append(int val) {
        if (size == 0) {
            array[size++] = val;
        }else {
            upAdjust(size, val);
            size++;
        }
    }

    /**
     * 添加元素后的上浮操作
     * @param index
     * @param val
     */
    public void upAdjust(int index, int val) {
        while (index > 0){
            int parentIndex = (index - 1) >>> 1;
            if (array[parentIndex] >= val) {
                break;
            }
            array[index] = array[parentIndex];
            index = parentIndex;
        }
        array[index] = val;
    }

    /**
     * 删除节点, 移除对顶元素，对其余的元素再构建大顶堆
     * @param index
     * @return
     */
    public void delete(int index){
        int valLast = array[size-1];
        if (index != size-1){
            downAdjust(index, valLast);
            if (array[index] == valLast){
                upAdjust(index, valLast);
            }
        }
        size--;
    }

    public void downAdjust(int index, int val){
        //最后一个元素父节点
        int parentIndex = size-1-1 >>> 1;
        while (index < parentIndex){
            int left = (index << 2) + 1;
            int right = left + 1;
            int best = 0;

            if (array[left] > array[right]){
                best = left;
            }else {
                best = right;
            }

            if (val >= array[best]){
                break;
            }
            array[index] = array[best];
            index = best;
        }
        array[index] = val;
    }

    /**
     * 获取最大的节点
     * @return
     */
    public int getTop(){
        return array[0];
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.append(1);
        binaryTree.append(4);
        binaryTree.append(0);
        binaryTree.append(10);
        binaryTree.append(6);
        System.out.println(binaryTree.getTop());
        binaryTree.delete(0);
        System.out.println(binaryTree.getTop());
    }

}
