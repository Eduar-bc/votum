import { jwtDecode } from "jwt-decode";

export function getUserRoles() {
  const token = localStorage.getItem("token");
  if (!token) return [];
  try {
    const decoded = jwtDecode(token);
    return decoded.roles || decoded.authorities || [];
  } catch (error) {
    console.error('Error al decodificar token:', error);
    return [];
  }
}

export function isCreator() {
  return getUserRoles().includes("ROLE_ELECTION_ADMIN");
}
