window.onload = function () {
  console.log("AI Cab Booking System Loaded Successfully");
};

// Booking Confirmation
function confirmBooking() {
  alert("Ride Booked Successfully!");
}
// Driver Status Update
function updateDriverStatus(driverName, status) {
  console.log(driverName + " status updated to " + status);
}

// Fare Estimation
function estimateFare() {
  let distance = document.getElementById("distance").value;

  if (distance === "") {
    alert("Enter Distance");
    return;
  }

  let fare = distance * 15;

  document.getElementById("fareResult").innerHTML = "Estimated Fare: ₹" + fare;
}
// Search Ride History
function searchRide() {
  let input = document.getElementById("searchRide").value.toLowerCase();

  let table = document.getElementById("rideTable");

  let tr = table.getElementsByTagName("tr");

  for (let i = 1; i < tr.length; i++) {
    let td = tr[i].getElementsByTagName("td")[1];

    if (td) {
      let textValue = td.textContent || td.innerText;

      if (textValue.toLowerCase().indexOf(input) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
// Live Clock for Dashboard
function liveClock() {
  const clock = document.getElementById("clock");

  if (clock) {
    setInterval(() => {
      let date = new Date();

      clock.innerHTML = date.toLocaleTimeString();
    }, 1000);
  }
}

liveClock();
