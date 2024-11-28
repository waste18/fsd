from flask import Flask, request, render_template, session
app2 = Flask(__name__)
app2.secret_key = 'super_secret_key'  # Set a secret key for session management
@app2.route('/')
def index():
   # Increment the visit count in the session
   session['visit_count'] = session.get('visit_count', 0) + 1
   return render_template('index_session.html', visit_count=session['visit_count'])
if __name__ == '__main__':
   app2.run(debug=True)