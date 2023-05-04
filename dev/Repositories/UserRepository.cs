using System.Data.SqlClient;
using System.Text;
using budgetor.Models;
using System.Security.Cryptography;

class UserRepository {
    public User queryUser(string a_email, string a_plainTextPassword, string a_connectionString) {
        User queriedUser = new User();

        try {
            using(SqlConnection connection = new SqlConnection()) {
                connection.ConnectionString = a_connectionString;
                connection.Open();

                using(SqlCommand queryCmd = new SqlCommand("SELECT * FROM budgetorUser where email = @a_email", connection)) {
                    queryCmd.Parameters.AddWithValue("@a_email", a_email);

                    using(SqlDataReader queryReader = queryCmd.ExecuteReader()) {
                        queryReader.Read();
                        if (hashPassword(a_plainTextPassword) != queryReader["password"].ToString())
                            return null;

                        queriedUser.Id = (int)queryReader["id"];
                        queriedUser.firstName = queryReader["firstName"].ToString() ?? "-";
                        queriedUser.lastName = queryReader["lastName"].ToString() ?? "-";
                        queriedUser.email = queryReader["email"].ToString() ?? "-";
                        queriedUser.password = queryReader["password"].ToString() ?? "-";
                    }
                }
            }
        } catch (SqlException ex) {
            Console.WriteLine($"There was a Database exception:\n{ex.Message}");
            return null;
        } catch(Exception ex) {
            Console.WriteLine($"There was an exception when trying to query the User...\n{ex.Message}");
            return null;
        }

        return queriedUser;
    }

    public string hashPassword(string a_plainTextPassword) {
        SHA256 hash = SHA256.Create();
        byte[] pwBytes = Encoding.Default.GetBytes(a_plainTextPassword);
        return System.Convert.ToHexString(hash.ComputeHash(pwBytes));
    }
}