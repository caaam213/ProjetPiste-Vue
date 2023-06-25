
// Fonction pour vérifier si l'utilisateur est authentifié
export function isAuthenticated() {
    // Vérifiez si le jeton d'authentification existe dans le stockage local (ou toute autre méthode d'authentification que vous utilisez)
    const token = localStorage.getItem('authToken');
    return !!token; // Renvoie true si le jeton existe, sinon false
}
