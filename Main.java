const mongoose = require('mongoose');

const userSchema = new mongoose.({
    username: String,
            password: String,
            role: {
        type: String,
        enum: ['admin', 'user'],
        default: 'user'
    }
});

module.exports = mongoose.model('User', userSchema);

        const jwt = require('jsonwebtoken');

        module.exports = function (req, res, next) {
        const token = req.headers.authorization?.split(' ')[1];
        if (!token) return res.status(401).json({ message: 'Unauthorized' });

        try {
        const decoded = jwt.verify(token, process.env.JWT_SECRET);
        req.user = decoded;
        next();
        } catch {
        res.status(401).json({ message: 'Invalid token' });
        }
        };

        module.exports = function (role) {
        return function (req, res, next) {
        if (req.user.role !== role) {
        return res.status(403).json({ message: 'Forbidden' });
        }
        next();
        };
        };

        const User = require('../models/User');
        const bcrypt = require('bcrypt');
        const jwt = require('jsonwebtoken');

        exports.register = async (req, res) => {
        const { username, password, role } = req.body;
        const hashed = await bcrypt.hash(password, 10);
        const user = await User.create({ username, password: hashed, role });
        res.json(user);
        };

        exports.login = async (req, res) => {
        const { username, password } = req.body;
        const user = await User.findOne({ username });
        if (!user || !(await bcrypt.compare(password, user.password))) {
        return res.status(401).json({ message: 'Invalid credentials' });
        }
        const token = jwt.sign({ id: user._id, role: user.role }, process.env.JWT_SECRET);
        res.json({ token });
        };

        const User = require('../models/User');

        exports.getProfile = async (req, res) => {
        const user = await User.findById(req.user.id);
        res.json(user);
        };

        exports.updateProfile = async (req, res) => {
        const user = await User.findByIdAndUpdate(req.user.id, req.body, { new: true });
        res.json(user);
        };

        exports.getAllUsers = async (req, res) => {
        const users = await User.find();
        res.json(users);
        };

        // authRoutes.js
        const express = require('express');
        const router = express.Router();
        const { register, login } = require('../controllers/authController');

        router.post('/register', register);
        router.post('/login', login);

        module.exports = router;

        // userRoutes.js
        const express = require('express');
        const router = express.Router();
        const auth = require('../middleware/authMiddleware');
        const role = require('../middleware/roleMiddleware');
        const { getProfile, updateProfile, getAllUsers } = require('../controllers/userController');

        router.get('/profile', auth, getProfile);
        router.put('/profile', auth, updateProfile);
        router.get('/admin/users', auth, role('admin'), getAllUsers);

        module.exports = router;

        require('dotenv').config();
        const express = require('express');
        const mongoose = require('mongoose');
        const app = express();

        app.use(express.json());

        mongoose.connect(process.env.MONGO_URI);

        app.use('/api/auth', require('./routes/authRoutes'));
        app.use('/api/user', require('./routes/userRoutes'));

        app.listen(3000, () => console.log('Server running on port 3000'));