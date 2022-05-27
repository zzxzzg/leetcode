package com.example.daliy;

import java.util.Scanner;

/**
 * @Created: lidong on 2022/5/5 2:24 PM
 * @Description: 日常练习
 * @version: 1.0.0
 */
public class Daily2022050501 {
    public static class LinkNode {
        public int val;
        public LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }

        public LinkNode move(int step) {
            LinkNode node = this;
            while (step > 0 && node != null) {
                node = node.next;
                step--;
            }
            return node;
        }

        public int getSize() {
            LinkNode node = this;
            int size = 0;
            while (node != null) {
                node = node.next;
                size++;
            }
            return size;
        }

        @Override
        public String toString() {
            LinkNode node = this;
            StringBuilder stringBuilder = new StringBuilder();
            while (node != null) {
                stringBuilder.append(node.val)
                    .append(",");
                node = node.next;
            }
            return "LinkNode{" + stringBuilder + "}";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String line = scanner.nextLine();
            LinkNode header = parseInput2LinkNode(line);
            if (header == null) {
                return;
            }
            int size = header.getSize();
            LinkNode sortedNode = sort(header, size);
            System.out.println(sortedNode);
        }

    }

    private static LinkNode sort(LinkNode linkNode, int size) {
        if (linkNode == null || size <= 0) {
            return null;
        }
        if (size == 1) {
            return linkNode;
        }
        if (size == 2) {
            if (linkNode.val > linkNode.next.val) {
                int temp = linkNode.val;
                linkNode.val = linkNode.next.val;
                linkNode.next.val = temp;
            }
            return linkNode;
        }

        int mid = size / 2;
        sort(linkNode, mid);
        LinkNode midNode = linkNode.move(mid);
        sort(midNode, size - mid);
        return mergeNode(linkNode, mid, midNode, size - mid);
    }

    private static LinkNode mergeNode(LinkNode head, int headCount, LinkNode tail, int tailSize) {
        LinkNode headIndex = new LinkNode(head.val);
        headIndex.next = head.next;
        LinkNode tempHeader = new LinkNode(0);
        LinkNode tempIndex = tempHeader;
        LinkNode lastNext = null;
        while (headCount > 0 || tailSize > 0) {
            if (headCount == 0) {
                tempIndex.next = tail;
                tailSize--;
                tail = tail.next;
                if (tailSize == 0) {
                    lastNext = tail;
                }
            } else if (tailSize == 0) {
                tempIndex.next = headIndex;
                headCount--;
                headIndex = headIndex.next;
            } else {
                if (headIndex.val > tail.val) {
                    tempIndex.next = tail;
                    tailSize--;
                    tail = tail.next;
                    if (tailSize == 0) {
                        lastNext = tail;
                    }
                } else {
                    tempIndex.next = headIndex;
                    headCount--;
                    headIndex = headIndex.next;
                }
            }
            tempIndex = tempIndex.next;
        }
        tempIndex.next = lastNext;
        head.val = tempHeader.next.val;
        head.next = tempHeader.next.next;
        return head;
    }

    private static LinkNode parseInput2LinkNode(String line) {
        if (line == null || line.trim()
            .length() == 0) {
            return null;
        }
        String[] str = line.trim()
            .split(" ");
        LinkNode header = new LinkNode(0);
        LinkNode temp = header;
        for (String s : str) {
            int val = Integer.parseInt(s.trim());
            temp.next = new LinkNode(val);
            temp = temp.next;
        }
        return header.next;
    }
}
