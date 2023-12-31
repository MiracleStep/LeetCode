package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 迷宫 {
    private static String[] nn = {
            "01010101001011001001010110010110100100001000101010",
            "00001000100000101010010000100000001001100110100101",
            "01111011010010001000001101001011100011000000010000",
            "01000000001010100011010000101000001010101011001011",
            "00011111000000101000010010100010100000101100000000",
            "11001000110101000010101100011010011010101011110111",
            "00011011010101001001001010000001000101001110000000",
            "10100000101000100110101010111110011000010000111010",
            "00111000001010100001100010000001000101001100001001",
            "11000110100001110010001001010101010101010001101000",
            "00010000100100000101001010101110100010101010000101",
            "11100100101001001000010000010101010100100100010100",
            "00000010000000101011001111010001100000101010100011",
            "10101010011100001000011000010110011110110100001000",
            "10101010100001101010100101000010100000111011101001",
            "10000000101100010000101100101101001011100000000100",
            "10101001000000010100100001000100000100011110101001",
            "00101001010101101001010100011010101101110000110101",
            "11001010000100001100000010100101000001000111000010",
            "00001000110000110101101000000100101001001000011101",
            "10100101000101000000001110110010110101101010100001",
            "00101000010000110101010000100010001001000100010101",
            "10100001000110010001000010101001010101011111010010",
            "00000100101000000110010100101001000001000000000010",
            "11010000001001110111001001000011101001011011101000",
            "00000110100010001000100000001000011101000000110011",
            "10101000101000100010001111100010101001010000001000",
            "10000010100101001010110000000100101010001011101000",
            "00111100001000010000000110111000000001000000001011",
            "10000001100111010111010001000110111010101101111000"};
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static char[][] mig = new char[30][50];
    static boolean[][] vis = new boolean[30][50];

    static class Node {
        int x;
        int y;
        String path;

        public Node(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            mig[i] = nn[i].toCharArray();
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, ""));
        vis[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) { //按照层次进行遍历，每一个层次视为一步。
                Node node = queue.poll();
                int x = node.x;
                int y = node.y;
                if (x == 29 && y == 49) {
                    System.out.println(node.path);
                    return;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = x + dir[k][0];
                    int ny = y + dir[k][1];
                    if (nx < 0 || ny < 0 || nx >= 30 || ny >= 50 || vis[nx][ny] || mig[nx][ny] == '1') {
                        continue; //越界、被访问过、有障碍物
                    }
                    vis[nx][ny] = true;

                    if (k == 0) {
                        queue.offer(new Node(nx, ny, node.path + "D"));
                    } else if (k == 1) {
                        queue.offer(new Node(nx, ny, node.path + "L"));
                    } else if (k == 2) {
                        queue.offer(new Node(nx, ny, node.path + "R"));
                    } else {
                        queue.offer(new Node(nx, ny, node.path + "U"));
                    }
                }
            }
        }
    }
}
