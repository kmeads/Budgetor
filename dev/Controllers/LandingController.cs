using Microsoft.AspNetCore.Mvc;
using System.Security.Claims;
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Authentication.Cookies;
using budgetor.Models;

namespace budgetor.Controllers {
    public class LandingController : Controller {
        public IActionResult home() => View();
        public IActionResult about() => View();
        public IActionResult app() => View();
        public IActionResult contact() => View();
        [HttpPost]
        public async Task<IActionResult> login(User a_user) => View();
    }
}
