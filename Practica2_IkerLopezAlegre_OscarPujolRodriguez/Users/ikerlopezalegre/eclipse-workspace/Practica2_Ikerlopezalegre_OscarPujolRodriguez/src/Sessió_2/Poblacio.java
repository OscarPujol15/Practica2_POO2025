public boolean eliminarUbicacio(Ubicacio c) {
    String CarrerString = c.getNomCarrer();
    char inicial = CarrerString.charAt(0);
    int idx;
    if (inicial < 90) {
        idx = inicial - 65;
    } else {
        idx = inicial - 97;
    }

    for (int j = 0; j < comptador[idx]; j++) {
        if (magatzem[idx][j].equals(c)) {
            for (int k = j; k < comptador[idx] - 1; k++) {
                magatzem[idx][k] = magatzem[idx][k + 1];
            }
            magatzem[idx][comptador[idx] - 1] = null;
            comptador[idx]--;
            return true;
        }
    }
    return false;
}