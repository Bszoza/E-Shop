// Otwórz modal i ustaw źródło obrazu
function openImageModal(imageSrc) {
    const modal = document.getElementById('imageModal');
    const modalImg = document.getElementById('modalImage');
    modal.style.display = 'flex'; // Wyświetl modal
    modalImg.src = imageSrc;     // Ustaw źródło obrazu w modalu
}

// Zamknij modal
function closeModal() {
    const modal = document.getElementById('imageModal');
    modal.style.display = 'none';
} // Ukryj modal