document.addEventListener("DOMContentLoaded", function () {
  const modal = document.getElementById("loginModal");

  document.querySelector(".open-modal-btn").addEventListener("click", function () {
    modal.style.display = "flex";
  });

  document.querySelector(".close-btn").addEventListener("click", function () {
    modal.style.display = "none";
  });
  
  document.querySelector(".btn-cancel").addEventListener("click", function () {
     modal.style.display = "none";
   });

  window.addEventListener("click", function (event) {
    if (event.target === modal) {
      modal.style.display = "none";
    }
  });
});
