class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // C'est mieux de déclarer le Map avec l'interface (Map)
        // au lieu de l'implémentation (HashMap)
        Map<String, List<String>> groups = new HashMap<>();
        
        // Déclarer ces variables à l'intérieur de la boucle
        // est plus propre et évite les erreurs de réinitialisation.
        
        for (String str : strs) {
            
            // 1. Crée un nouveau tableau de comptage (initialisé à 0)
            int[] counts = new int[26];
            
            // 2. Crée un nouveau StringBuilder
            StringBuilder keyBuilder = new StringBuilder();
            
            // 3. Compte les caractères
            for (char c : str.toCharArray()) {
                counts[c - 'a']++;
            }
            
            // 4. Construit la clé unique (signature)
            for (int count : counts) {
                keyBuilder.append('#'); // Ajoute le séparateur
                keyBuilder.append(count);
            }
            String key = keyBuilder.toString();
            
            // 5. Ajoute le mot à la bonne liste dans la map
            // Crée la liste si elle n'existe pas
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        // 6. Retourne toutes les listes (les valeurs) de la map
        // C'est .values() (au pluriel) et non .value()
        return new ArrayList<>(groups.values());
    }
}