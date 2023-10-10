package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {

    Environnement environnement;

    public BFS(Environnement environnement) {

        this.environnement = environnement;
    }

    public void calculerChemin(int destX, int destY) {  // Méthode modifiée pour calculer les distances à la destination

        boolean[][] visited = new boolean[environnement.getYmax()][environnement.getXmax()];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(destX);
        queue.offer(destY);
        visited[destY][destX] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValidMove(nx, ny) && !visited[ny][nx]) {
                    queue.offer(nx);
                    queue.offer(ny);
                    visited[ny][nx] = true;
                    environnement.distances[ny][nx] = environnement.distances[y][x] + 1;
                }
            }
        }
    }

    public boolean isValidMove(int x, int y) {

        return x >= 0 && x < this.environnement.distances[0].length && y >= 0 && y < this.environnement.distances.length && this.environnement.valeurDeLaCase(y, x) == 1;
    }
    }

