public boolean afegirSenyal(SenyalTransit c, int numero) {
        // Comprobar si hay que ampliar el array
        if (this.numSenyals >= this.MAX_SENYALS) {
            this.MAX_SENYALS += 10;
            SenyalTransit[] newSenyals = new SenyalTransit[MAX_SENYALS];
            int[] newOnEstanSenyals = new int[MAX_SENYALS];
            
            for (int i = 0; i < numSenyals; i++) {
                newSenyals[i] = this.senyals[i];
                newOnEstanSenyals[i] = this.onEstanSenyals[i];
            }
            this.senyals = newSenyals;
            this.onEstanSenyals = newOnEstanSenyals;
        }

        // Comprobar si ya existe la señal
        for (int i = 0; i < numSenyals; i++) {
            if (this.senyals[i] != null && this.senyals[i].getCodi().equals(c.getCodi())) {
                return false;
            }
        }

        // Añadir la nueva señal al final
        this.senyals[numSenyals] = c;
        this.onEstanSenyals[numSenyals] = numero;
        this.numSenyals++;
        return true;
    }