using Microsoft.AspNetCore.Mvc;
using System.Security.Claims;
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Authentication.Cookies;
using budgetor.Models;

namespace budgetor.Controllers {
    public class LandingController : Controller {
        private IConfiguration config;
        private readonly ILogger<LandingController> logger;

        public LandingController(ILogger<LandingController> a_logger, IConfiguration a_config) {
            this.logger = a_logger;
            this.config = a_config;
        }

        public IActionResult home() => View();
        public IActionResult about() => View();
        public IActionResult app() => View();
        public IActionResult contact() => View();
        [HttpPost]
        public async Task<IActionResult> login(User a_user) {
            //if(a_user.email)


            return View();
        }
    }
}
