<script>
	import {Terminal} from './components/components.module.js'
	import {SsrTerminal} from './components/components.module.js'
	import './tailwind.css'
</script>

<style>
	:global(body) {
		background: #fff;
	}

	.terminal-wrapper {
		margin: 20px 10%;
		margin-top: 200px;
		margin-bottom: 2000px;
	}

	@media (max-width: 650px) {
		.terminal-wrapper {
			margin: 20px 2%;
		}
	}
</style>

<div class="terminal-wrapper">
	<Terminal event={undefined} />
</div>

<div class="terminal-wrapper">
	<SsrTerminal event={null} />
</div>
