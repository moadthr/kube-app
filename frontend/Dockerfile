FROM node:16.13.0-alpine as build

WORKDIR /app

COPY package.json .
COPY package-lock.json .
RUN npm install --silent
COPY . .
RUN npm run build

# Stage 2: Create a lightweight production image
FROM nginx:1.21.3-alpine

# Copy the build files from the previous stage
COPY --from=build /app/build /usr/share/nginx/html
# Copy custom Nginx configuration
COPY conf/nginx.conf /etc/nginx/conf.d/default.conf

# Expose port 80
EXPOSE 80

# Start Nginx when the container starts
CMD ["nginx", "-g", "daemon off;"]
