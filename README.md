<h1>Restricted Environment</h1>
<p>Welcome to the RestrictedEnvironment repository. This project focuses on creating an isolated environment, the "Jail environment," for secure code submission evaluation.</p>
<h2>Jail Environment Overview</h2>
<p>In automating programming assignment grading, the Jail environment executes student code submissions separately from the main application. This isolation minimizes unauthorized access risks and security breaches.</p>
<h3>Requirement</h3>
<p>The main requirement was to create a secure mechanism for isolated code execution, preventing unintended code from affecting the main application.</p>
<h3>Implementation</h3>
<p>The Jail environment's implementation involved:</p>
<ol>
   <li>
      <p><strong>Spring Boot Application:</strong> A REST API in a Spring Boot application for code submission and test case evaluation.</p>
   </li>
   <li>
      <p><strong>API Methods:</strong> Key methods include uploading code submissions and assessing them against test cases.</p>
   </li>
   <li>
      <p><strong>Main App Integration:</strong> The main app interacts with the isolated environment using the REST API to calculate marks based on test case results.</p>
   </li>
   <li>
      <p><strong>Docker Containerisation:</strong> The Spring Boot app was containerised using Docker to ensure true isolation and security.</p>
   </li>
</ol>
<h2>Conclusion</h2>
<p>The RestrictedEnvironment repository solves a critical problem in automated programming assignment grading by ensuring secure, isolated code execution. With the Jail environment, student code submissions are evaluated securely, minimizing risks to the main application and the host system.</p>
