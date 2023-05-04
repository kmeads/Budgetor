namespace budgetor.Models {
    public class User {
        public int Id { get; set; } = 0;
        public string firstName { get; set; } = string.Empty;
        public string lastName { get; set; } = string.Empty;
        public string email { get; set; } = string.Empty;
        public string phone { get; set; } = string.Empty;
        public string password { get; set; } = string.Empty;

        public string getName() => $"{this.firstName} {this.lastName}"; 
        public override string ToString() => $"User {this.Id}:\n\tName: {this.getName()}\n\tEmail: {this.email}\n\tPhone: {this.phone}";
    }
}
