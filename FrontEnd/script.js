const API = "http://localhost:8080/api";

function toggleTheme() {
  const body = document.body;
  body.classList.toggle('dark');
  body.classList.toggle('light');
}

function register() {
  const owner = document.getElementById("owner").value;
  fetch(`${API}/register?owner=${owner}`, { method: "POST" })
    .then((res) => res.json())
    .then((data) => {
      document.getElementById("registerResult").textContent =
        `✅ Registered: ID=${data.id}, Name=${data.owner}`;
    });
}

function deposit() {
  const id = document.getElementById("depId").value;
  const amt = document.getElementById("depAmt").value;
  fetch(`${API}/deposit?id=${id}&amt=${amt}`, { method: "POST" })
    .then((res) => res.json())
    .then((data) => {
      document.getElementById("depositResult").textContent =
        `✅ Deposited! New Balance: ₹${data.balance}`;
    });
}

function withdraw() {
  const id = document.getElementById("withId").value;
  const amt = document.getElementById("withAmt").value;
  fetch(`${API}/withdraw?id=${id}&amt=${amt}`, { method: "POST" })
    .then((res) => res.json())
    .then((data) => {
      document.getElementById("withdrawResult").textContent =
        `✅ Withdrew! New Balance: ₹${data.balance}`;
    });
}

function checkBalance() {
  const id = document.getElementById("balId").value;
  fetch(`${API}/balance?id=${id}`)
    .then((res) => res.text())
    .then((balance) => {
      document.getElementById("balanceResult").textContent =
        `💰 Balance: ₹${balance}`;
    });
}

function getHistory() {
  const id = document.getElementById("histId").value;
  fetch(`${API}/history?id=${id}`)
    .then((res) => res.json())
    .then((data) => {
      const list = document.getElementById("historyResult");
      list.innerHTML = "";
      data.forEach((item) => {
        const li = document.createElement("li");
        const rawDate = item.date || item.timestamp || item.createdAt || null;
        const formattedDate = rawDate
          ? new Date(rawDate).toLocaleString()
          : "Unknown date";
        li.textContent = `📄 ${item.type} ₹${item.amount} on ${formattedDate}`;
        list.appendChild(li);
      });
    });
}
