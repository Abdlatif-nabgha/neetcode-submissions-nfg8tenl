class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Création d'une HashMap pour stocker les nombres et leurs indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Parcourir le tableau une seule fois
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calcul du complément

            // Vérifier si le complément existe déjà dans la map
            if (map.containsKey(complement)) {
                // Si oui, retourner les deux indices (complément, actuel)
                return new int[] { map.get(complement), i };
            }

            // Sinon, enregistrer la valeur actuelle avec son indice
            map.put(nums[i], i);
        }

        // En principe inutile car l'énoncé garantit une solution
        return new int[] {};
    }
}
