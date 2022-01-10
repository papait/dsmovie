import { ReactComponent as Githubicon } from 'assets/img/github.svg'
import './styles.css';
function Navbar() {

    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1>DSmovie</h1>
                    <a href="https://github.com/papait/">
                        <div className='demovie-contact-container'>
                            <Githubicon />
                            <p className='dsmovie-contact-link'>/papait</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;